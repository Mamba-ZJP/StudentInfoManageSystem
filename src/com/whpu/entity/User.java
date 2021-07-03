package com.whpu.entity;

// 实体类：声明属性--和表中字段对应
public class User {
    private Integer id; // 用户编号
    private String username;
    private String password;
    private String phone;
    private Integer status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
// 创建get, set方法 取值和赋值操作

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAll(String username, String password, String phone, Integer status) {
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.status = status;
    }
    // 重写toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
