package com.iflytek.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: sxf
 * @Date:2021/04/16/9:15
 * @Description:
 */
//@Target注解	功能：指明了修饰的这个注解的使用范围，即被描述的注解可以用在哪里。
//@Retention注解 功能：指明修饰的注解的生存周期，即会保留到哪个阶段。
//@Documented注解只是用来做标识，没什么实际作用，了解就好。
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LogAspect {
    //模块
    String module() default "";
    //描述
    String description() default "";
}
