package com.whpu.dao;

import com.whpu.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    // 获取所有学生信息：多个学生，返回集合类型
    public List<Student> selectAllStu() throws SQLException;

    // 学生登陆
    public Student login(String name, String pwd) throws SQLException;

}
