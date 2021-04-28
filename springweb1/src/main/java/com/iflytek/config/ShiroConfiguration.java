package com.iflytek.config;

import com.iflytek.pojo.Permission;
import com.iflytek.service.PermissionService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author: sxf
 * @Date:2021/04/28/8:16
 * @Description:配置类
 */
@Configuration
public class ShiroConfiguration {

    @Autowired
    private PermissionService permissionService;

    // 过滤器：ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);

        //内置拦截器
        Map<String,String> filterMap = bean.getFilterChainDefinitionMap();
        /**
         * anon:无需认证可以访问
         * authc：必须认证才能访问
         * user：必须拥有 记住才能用
         * parms：拥有对某个资源才能访问
         * role：拥有某个角色才能访问
         * perms：用户对应权限才能访问perms['1-1']
         */

        //遍历数据获取所有的权限信息
        List<Permission> permList = permissionService.permissionList();//查询所有权限数据
        for (Permission permission : permList) {
            filterMap.put(permission.getUrl(),"perms["+permission.getId()+"]");
        }

        bean.setLoginUrl("/");//登录页面
        //添加所有路径的过滤，并排除到静态资源信息
        filterMap.put("/","anon");
        filterMap.put("/login/*","anon");
        filterMap.put("/css/*","anon");
        filterMap.put("/fonts/*","anon");
        filterMap.put("/images/*","anon");
        filterMap.put("/js/*","anon");
        filterMap.put("/lib/**","anon");
        filterMap.put("/**","authc");

        return bean;
    }
    // 安全管理器：DefaultWebSecurityManager
    // 因为SecurityManager需要一个Realm数据，而前面已经用Bean注解创建了Realm的对象
    // 所以这里应该直接从Spring容器中去找这个Bean对象，因此用参数的形式来注入，并用注解获取它
    // 这里使用Qualifier注解，作用：在按照类型注入的基础之上，再按照名称注入。
    // 它在给类成员注入时不能单独使用，但是在给方法参数注入时可以单独使用。
    // 最终这里的SecurityManager也要作为Bean对象进入Spring容器，让ShiroFilter去使用
    @Bean("securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm")MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }
    // 数据域：Realm
    // Bean注解表示这个方法的返回值将创建一个Bean对象并交给Spring容器管理
    // 默认这个Bean对象的名字为方法名，可以通过参数设置
    @Bean(name = "myRealm")
    public MyRealm getMyRealm(){
        return new MyRealm();
    }
}
