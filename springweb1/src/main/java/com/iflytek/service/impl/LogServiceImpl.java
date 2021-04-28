package com.iflytek.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iflytek.dao.LogMapper;
import com.iflytek.pojo.LogBean;
import com.iflytek.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/23/8:14
 * @Description:
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;

    @Override
    public List logList() {
        return logMapper.selectList(null);
    }

    @Override
    public int batchDelLog(List ids) {
        return logMapper.deleteBatchIds(ids);
    }

    @Override
    public int insertLog(LogBean logBean) {
        return logMapper.insert(logBean);
    }

    @Override
    public List queryLog(QueryWrapper<LogBean> wrapper) {
        return logMapper.selectList(wrapper);
    }
}
