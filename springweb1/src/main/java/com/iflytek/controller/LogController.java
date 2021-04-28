package com.iflytek.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iflytek.pojo.LogBean;
import com.iflytek.service.LogService;
import com.iflytek.util.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: sxf
 * @Date:2021/04/16/9:30
 * @Description:
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("/logList")
    public String logList(Model model){
        //Map<Long, LogBean> logMap = StaticData.logBeanMap;
        //List list = logMap.values();
        List<LogBean> logList = logService.logList();
        model.addAttribute("logList",logList);
        return "log-list";
    }

    @GetMapping("/batchdelLog")
    @ResponseBody
    public boolean batchdelLog(String ids) {
        boolean rel = logService.batchDelLog(Arrays.asList(ids.split(","))) > 0;
        return rel;
    }

    @GetMapping("/queryLog")
    public String queryLog(String userName,Model model) {
        //构造器实例化
        QueryWrapper<LogBean> wrapper = new QueryWrapper();
        wrapper.likeRight("user_name",userName);
        List<LogBean> logList = logService.queryLog(wrapper);
        model.addAttribute("logList",logList);
        model.addAttribute("userName",userName);
        return "log-list";
    }
}
