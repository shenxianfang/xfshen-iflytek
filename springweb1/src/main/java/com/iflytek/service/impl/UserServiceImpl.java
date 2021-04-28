package com.iflytek.service.impl;

import com.iflytek.dao.IUserDao;
import com.iflytek.dao.UserDao;
import com.iflytek.pojo.User;
import com.iflytek.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/12/8:29
 * @Description:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    IUserDao userDao;
    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }

    @Override
    public User queryUser(Integer id) {
        return userDao.queryUser(id);
    }

    @Override
    public User queryUserByAccount(String account) {
        return userDao.queryUserByAccount(account);
    }

    @Override
    //@Transactional
    public boolean insertUser(User user) {
        int rel = userDao.insertUser(user);
//        log.info("新增一条用户信息成功！-------------------");
//        if (user.getAccount().length() <3 || user.getAccount().length() >6) {
//            throw new RuntimeException("用户账号长度有误！");
//        }
//        log.info("执行完成，结果输出："+rel+"-----------------");
        return rel > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }

    @Override
    public boolean deleteUer(Integer id) {
        return userDao.deleteUser(id) > 0;
    }
}
