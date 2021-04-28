package com.iflytek.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.pojo.LogBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: sxf
 * @Date:2021/04/23/8:12
 * @Description:
 */
@Mapper
public interface LogMapper extends BaseMapper<LogBean> {
}
