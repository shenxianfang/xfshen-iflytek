package com.iflytek.aspect;

import com.iflytek.controller.BaseController;
import com.iflytek.pojo.LogBean;
import com.iflytek.pojo.User;
import com.iflytek.service.LogService;
import com.iflytek.util.StaticData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author: sxf
 * @Date:2021/04/16/8:57
 * @Description:
 */

//@aspect为类上面的注解——切面
//@pointcut(…)——切入点。为此类内一个空方法上面的注解。可以把拦截的地址表达式表示为方法签名，利于使用起来方便。
//@before@after等——通知。为此类下面的方法上面的注解。
//三者在一块组成一个切面。

@Aspect
@Slf4j
@Component
public class WebAspect extends BaseController {
    @Autowired
    LogService logService;
    //切入点--定义个范围
    @Pointcut("@annotation(LogAspect)")//使用注解方式定义一个切点
    public void logPointcut(){};

    @Before("logPointcut() && @annotation(logAspect)")
    public void beforeLog(LogAspect logAspect){
        User user = getAccount();
        String url = getRequest().getRequestURI();
        Map<Long, LogBean> logBeanMap = StaticData.logBeanMap;
        LogBean logs = new LogBean();
        logs.setDate(new Date());
        logs.setUrl(getRequest().getRequestURI());
        logs.setModule(logAspect.module());
        logs.setDescription(logAspect.description());
        logs.setUserAccount(user.getAccount());
        logs.setUserName(user.getName());
        logService.insertLog(logs);
        //logBeanMap.put(logs.getDate().getTime(),logs);
        //log.info(new Date()+"用户"+user.getAccount()+"访问了"+url+"--"+logAspect.module()+"--"+logAspect.description());
    }

}
