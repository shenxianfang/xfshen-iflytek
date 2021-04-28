package com.iflytek.controller;

import com.iflytek.pojo.User;
import com.iflytek.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

/**
 * @author: sxf
 * @Date:2021/04/12/8:06
 * @Description:
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/toLogin")
    public String toLogin(String username, String password, Model model, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (Throwable e){
            if (e instanceof UnknownAccountException) {
                model.addAttribute("msg","用户名错误或不存在");
            } else {
                model.addAttribute("msg","密码错误");
            }
            return "login";
        }
        //此步是因为已存在的session的信息不是我们想要的，为方便起见，验证成功再查询一次后台获取用户信息
        User user = userService.queryUserByAccount(username);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return "redirect:/index";
    }

    /**
     * 退出登录
     * @param model
     * @return
     */
    @GetMapping("/outLogin")
    public String outLogin(Model model){
        HttpSession session = getRequest().getSession();
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 注册用户
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * 注册用户信息
     * @param user
     * @return
     */
    @PostMapping("/registerUser")
    public boolean insertUser(User user){
        return userService.insertUser(user);
    }
}
