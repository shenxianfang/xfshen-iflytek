package com.iflytek.config;

import com.iflytek.pojo.Role;
import com.iflytek.pojo.User;
import com.iflytek.service.RoleService;
import com.iflytek.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: sxf
 * @Date:2021/04/28/8:17
 * @Description:
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = principalCollection.getPrimaryPrincipal().toString();
        User user = userService.queryUserByAccount(userName);
        if (user == null || user.getAccount() == null) {
            throw new UnknownAccountException();//抛出异常
        }
        //获取到用户对应的角色 ，根据角色得到角色所有的权限
        //授权认证器
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(user.getRoleId() != null) {
            Role role = roleService.queryRoleById(user.getRoleId());//获取角色
            for (String key : role.getRolePerm().split(",")) {
                info.addStringPermission(key);
            }
        }
        return info;
    }

    //认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = authenticationToken.getPrincipal().toString();//获取输入的账号

        User user = userService.queryUserByAccount(userName);
        if (user == null || user.getAccount() == null) {
            throw new UnknownAccountException();//抛出异常
        }
        //执行认证-
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,user.getPwd(),this.getName());
        return authenticationInfo;
        //return null;
    }
}
