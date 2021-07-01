package com.whpu.dao;

import com.whpu.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    // 获取所有学生信息：多个学生，返回集合类型
    public List<Student> selectGradeStu(String name) throws SQLException;

    // 学生登陆
    public Student login(String name, String pwd) throws SQLException;

    // 修改1 根据学生编号查询学生信息
    public Student selectOneStuBySid(Integer sid) throws SQLException;

    // 修改2 编辑页面完成，点击修改保存（更新保存）
    public void updateStu(Student student) throws SQLException;
}
