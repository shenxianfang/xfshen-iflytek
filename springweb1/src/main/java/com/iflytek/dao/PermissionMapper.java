package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: sxf
 * @Date:2021/04/27/8:59
 * @Description:
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
