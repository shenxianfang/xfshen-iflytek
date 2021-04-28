package com.iflytek.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iflytek.pojo.LogBean;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/23/8:13
 * @Description:
 */
public interface LogService {
    //查询所有日志信息
    List logList();

    //批量删除
    int batchDelLog(List ids);

    //新增日志信息
    int insertLog(LogBean logBean);

    //根据条件查询信息
    List queryLog(QueryWrapper<LogBean> wrapper);
}
