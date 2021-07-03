package com.whpu.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.whpu.entity.Student;
import com.whpu.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImplement implements UserDao {
    // 操作数据库的类，封装了增删改查的操作 需要数据源参数
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    @Override
    public User login(String name, String pwd) throws SQLException {
        String sql = "SELECT * FROM USER WHERE username = ? AND PASSWORD = ?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), name, pwd);
        return user;
    }

    public List<Student> selectAllStu() throws SQLException {
        String sql = "SELECT * FROM student";
        return qr.query(sql, new BeanListHandler<Student>(Student.class));
    }

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO user(username, password, phone, status) values(?, ?, ?, ?)";
        qr.update(sql, user.getUsername(), user.getPassword(), user.getPhone(), user.getStatus());
    }
}
