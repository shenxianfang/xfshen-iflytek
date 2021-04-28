package com.iflytek.service;

import com.iflytek.pojo.Role;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/27/8:51
 * @Description:
 */
public interface RoleService {
    /**
     * 角色所有列表
     * @return
     */
    public List<Role> roleList();

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    Role queryRoleById(Long id);

    /**
     * 新增角色
     * @param role
     * @return
     */
    int insertRole(Role role);

}
