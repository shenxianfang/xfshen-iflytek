package com.iflytek.controller;

import com.iflytek.aspect.LogAspect;
import com.iflytek.pojo.Role;
import com.iflytek.pojo.User;
import com.iflytek.service.RoleService;
import com.iflytek.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: sxf
 * @Date:2021/04/12/8:18
 * @Description:
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController{

    @Autowired
    UserServiceImpl userService;
    @Autowired
    private RoleService roleService;


    //展现数据列表
    @GetMapping("/userList")
    public String userList(Model model){
        List<User> userList = userService.allUser();
        model.addAttribute("userList",userList);
        List<Role> roleList = roleService.roleList();
        Map<Long,String> roleMap = roleList.stream().
                collect(Collectors.toMap(Role::getId, Role::getRoleName));
        model.addAttribute("roleMap",roleMap);
        return "member-list";
    }


    //新增用户页面
    @GetMapping("/addUser")
    public String addUser(Model model){
        List<Role> roleList = roleService.roleList();
        model.addAttribute("roleList",roleList);
        return "member-add";
    }

    @PostMapping("/insertUser")
    @ResponseBody
    @LogAspect(module = "用户管理",description = "新增一个用户")
    public boolean insertUser(User user){
        return userService.insertUser(user);
    }

    //@PathVariable("xxx")
    //通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
    @GetMapping("/editUser/{id}")

    public String editUser(@PathVariable("id") Integer id, Model model){
        User user = userService.queryUser(id);
        model.addAttribute("user",user);
        List<Role> roleList = roleService.roleList();
        model.addAttribute("roleList",roleList);
        return "member-edit";
    }

    @PostMapping("/updateUser")
    @ResponseBody
    @LogAspect(module = "用户管理",description = "更新用户")
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/deleteUser/{id}")
    @ResponseBody
    @LogAspect(module = "用户管理",description = "删除用户")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteUer(id);
    }
}
