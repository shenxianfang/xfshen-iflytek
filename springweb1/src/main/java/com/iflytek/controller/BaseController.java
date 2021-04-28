package com.iflytek.controller;

import com.iflytek.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author: sxf
 * @Date:2021/04/15/14:27
 * @Description:
 */
@Controller
public class BaseController {
    private static final String  USER = "user";

    public HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public User getAccount() {
        HttpSession session = getRequest().getSession();
        return (User) session.getAttribute(USER);
    }

    public void setAccount(User user) {
        HttpSession session = getRequest().getSession();
        if (user != null) {
            session.setAttribute(USER, user);
        }
    }
}
