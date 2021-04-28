package com.iflytek.pojo;

import java.io.Serializable;

/**
 * @author: sxf
 * @Date:2021/04/09/9:09
 * @Description:
 */
public class User implements Serializable {
    private Integer id;
    private String account;//用户账号
    private String name;//用户名
    private String pwd;//密码
    private String address;//地址
    private String phone;//电话号码
    private Long roleId;//角色ID

    public User() {
    }

    public User(Integer id, String account, String name, String pwd, String address, String phone, Long roleId) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.pwd = pwd;
        this.address = address;
        this.phone = phone;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
