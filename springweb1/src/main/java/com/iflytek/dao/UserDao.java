package com.iflytek.dao;

import com.iflytek.pojo.User;
import com.iflytek.util.StaticData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: sxf
 * @Date:2021/04/12/8:22
 * @Description:
 */
@Repository
public class UserDao {
    Map<Integer,User> userMap = StaticData.userMaps;
    //查询所有的用户
    public List<User> allUser(){
        return new ArrayList<>(userMap.values());
    }

    //根据条件查询
    public User queryUser(Integer id) {
        return userMap.get(id);
    }

    //根据用户账户查找
    public User queryUserByAccount(String account){
        User relUser = new User();
        for (User user : userMap.values()) {
            if (account.equals(user.getAccount())) {
                relUser = user;
                break;
            }
        }
        return relUser;
    }


    //新增一个user
    public boolean insertUser(User user) {
        userMap.put(user.getId(),user);
        return true;
    }

    //更新user
    public boolean updateUser(User user) {
        userMap.put(user.getId(),user);
        return true;
    }

    //删除user
    public boolean deleteUser(Integer id) {
        userMap.remove(id);
        return true;
    }
}
