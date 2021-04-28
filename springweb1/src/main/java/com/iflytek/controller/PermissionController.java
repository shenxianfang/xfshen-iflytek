package com.iflytek.controller;

import com.iflytek.pojo.Permission;
import com.iflytek.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/27/9:05
 * @Description:
 */
@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permissionList")
    public String permissionList(Model model) {
        List<Permission> permissionList = permissionService.permissionList();
        model.addAttribute("permissionList",permissionList);
        return null;
    }
}
