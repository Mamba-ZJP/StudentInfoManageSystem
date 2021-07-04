package com.whpu.dao;

import com.whpu.entity.Student;
import com.whpu.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    // 实现登录：方法要素 访问修饰符 返回值 方法名 参数
    // 查询数据库表，如果查询到用户名和密码匹配，返回当前用户（对象）
    public User login(String name, String pwd) throws SQLException;

    public List<Student> selectAllStu() throws SQLException;

    public void addUser(User user) throws SQLException;

    public void changePwd(String username, String pwd) throws SQLException;
}
