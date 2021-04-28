package com.iflytek.service.impl;

import com.iflytek.dao.PermissionMapper;
import com.iflytek.pojo.Permission;
import com.iflytek.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/27/9:02
 * @Description:
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> permissionList() {
        return permissionMapper.selectList(null);
    }

    @Override
    public Permission queryPermissionById(String id) {
        return permissionMapper.selectById(id);
    }
}
