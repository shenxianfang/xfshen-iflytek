package com.iflytek.controller;

import com.iflytek.pojo.User;
import com.iflytek.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/09/9:02
 * @Description:
 */
@Controller
@Slf4j
public class IndexController extends BaseController{

    @Autowired
    UserServiceImpl userService;
    //private static  final Logger logger = LoggerFactory.getLogger(IndexController.class);



    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("user",getAccount());
        return "index";
    }

    /**
     * 跳转到列表页面
     * @return
     */
    @GetMapping("/memberList")
    public String memberList(){
        return "member-list";
    }

    @GetMapping("/test")
    @ResponseBody
    public void logTest(){
        log.info("这是一个info");
        log.error("error");
        log.warn("warn");
        log.debug("debug");

    }

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/welcome/{id}")
    public String welcome(@PathVariable("id") Integer id,Model model){
        User user = userService.queryUser(id);
        model.addAttribute("user",user);
        return "welcome";
    }


}
