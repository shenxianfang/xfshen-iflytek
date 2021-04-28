package com.iflytek.util;

import com.iflytek.pojo.LogBean;
import com.iflytek.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: sxf
 * @Date:2021/04/09/11:18
 * @Description:
 */
public class StaticData {
    public static Map<Integer, User> userMaps = null;
   static {
       userMaps = new HashMap<Integer, User>();
//       userMaps.put(101,new User(101,"lisi1","李四1","123456","安徽芜湖","13721306218"));
//       userMaps.put(102,new User(102,"lisi2","李四2","123456","安徽芜湖","13721206218"));
//       userMaps.put(103,new User(103,"lisi3","李四3","123456","安徽芜湖","13721206218"));
//       userMaps.put(104,new User(104,"lisi4","李四4","123456","安徽芜湖","13721206218"));
   }
   public static Map<Long, LogBean> logBeanMap = new HashMap<>();
}
