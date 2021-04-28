package com.iflytek.service;

import com.iflytek.pojo.User;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/12/8:28
 * @Description:
 */
public interface UserService {
    public List<User> allUser();
    public User queryUser(Integer id);
    public User queryUserByAccount(String account);
    public boolean insertUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUer(Integer id);
}
