package com.iflytek.service;

import com.iflytek.pojo.Permission;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/27/9:00
 * @Description:
 */
public interface PermissionService {
    /**
     * 查询所有权限
     * @return
     */
    List<Permission> permissionList();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Permission queryPermissionById(String id);
}
