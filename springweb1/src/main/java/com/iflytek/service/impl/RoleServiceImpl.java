package com.iflytek.service.impl;

import com.iflytek.dao.RoleMapper;
import com.iflytek.pojo.Role;
import com.iflytek.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/27/8:52
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> roleList() {
        return roleMapper.selectList(null);
    }

    @Override
    public Role queryRoleById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public int insertRole(Role role) {
        return roleMapper.insert(role);
    }

}
