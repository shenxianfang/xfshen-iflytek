package com.iflytek.dao;

import com.iflytek.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: sxf
 * @Date:2021/04/21/16:31
 * @Description:
 */
@Mapper
public interface IUserDao {
    //查询所有
    //@Select("select * from user")
    List<User> allUser();
    //根据id查询数据
    //@Select("select * from user where id=#{id}")
    User queryUser(Integer id);
    //根据用户查询数据
    //@Select("select * from user where account=#{account}")
    User queryUserByAccount(String account);
    //新增数据
    //@Insert("insert into user(account,name,pwd,address,phone) value(#{account},#{name},#{pwd},#{address},#{phone})")
    int insertUser(User user);
    //更新数据
   // @Update("update user set account=#{account},name=#{name},pwd=${pwd},address=#{address},phone=#{phone} where id=#{id}")
    int updateUser(User user);
    //删除数据
    //@Delete("delete from user where id = #{id}")
    int deleteUser(Integer id);
}
