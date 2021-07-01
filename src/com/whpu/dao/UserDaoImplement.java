package com.whpu.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.whpu.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImplement implements UserDao {
    // 操作数据库的类，封装了增删改查的操作 需要数据源参数
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    @Override
    public User login(String name, String pwd) throws SQLException {
        String sql = "SELECT * FROM USER WHERE username = ? AND PASSWORD = ?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), name, pwd);
        return user;
    }
}
