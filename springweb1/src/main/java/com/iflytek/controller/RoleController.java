package com.iflytek.controller;

import com.iflytek.pojo.Permission;
import com.iflytek.pojo.Role;
import com.iflytek.service.PermissionService;
import com.iflytek.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: sxf
 * @Date:2021/04/26/16:47
 * @Description:
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    /**
     * 跳转到用户角色列表
     * @param model
     * @return
     */
    @GetMapping("/roleList")
    public String roleList(Model model){
        List<Role> roleList = roleService.roleList();
        //查询权限list 用于显示值的转换
        List<Permission> permissionList = permissionService.permissionList();

        //权限list转Map
        Map<String, String> permMap = permissionList.stream().
                collect(Collectors.toMap(Permission::getId, Permission::getPermissionName));
        //遍历角色列表
        for (Role role : roleList) {
            //获取权限ID
            String[] permArr =role.getRolePerm().split(",");
            List<String> permNameList = new ArrayList<>();
            for (String key : permArr) {
                permNameList.add(permMap.get(key));
            }
            role.setRolePerm(permNameList.toString());
        }
        model.addAttribute("roleList",roleList);
        return "admin-role";
    }


    /**
     * 跳转到新增页面
     * @param model
     * @return
     */
    @GetMapping("/addRole")
    public String addRole(Model model) {
        List<Permission> permissionList = permissionService.permissionList();
        model.addAttribute("permissionList",permissionList);
        return "role-add";
    }


    /**
     * 保存角色
     * @param role
     * @return
     */
    @PostMapping("/insertRole")
    @ResponseBody
    public boolean insertRole(Role role) {
        int rel = roleService.insertRole(role);
        return rel > 0;
    }
}
