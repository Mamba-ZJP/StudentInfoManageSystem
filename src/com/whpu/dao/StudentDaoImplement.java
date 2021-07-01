package com.whpu.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.whpu.entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImplement implements StudentDao {

    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    @Override
    public List<Student> selectGradeStu(String name) throws SQLException {
        String sql = "SELECT * FROM student WHERE gradeid = (SELECT gradeid FROM student WHERE sname=?)";
        List<Student> studentList = qr.query(sql, new BeanListHandler<Student>(Student.class), name);
        return studentList;
    }

    @Override
    public Student login(String name, String pwd) throws SQLException {
        String sql = "select * from student where sname=? and password=?";
        return qr.query(sql, new BeanHandler<Student>(Student.class), name, pwd);
    }

    @Override
    public Student selectOneStuBySid(Integer sid) throws SQLException {
        String sql = "SELECT * FROM student WHERE sid=?";
        return qr.query(sql, new BeanHandler<Student>(Student.class), sid);
    }

    @Override
    public void updateStu(Student student) throws SQLException {
        String sql = "UPDATE student SET sname=?,sno=?,gradeid=?,address=?,score=?,PASSWORD=? WHERE sid =?";
        qr.update(sql, student.getSname(), student.getSno(), student.getGradeid(), student.getAddress(),
                student.getScore(), student.getPassword(), student.getSid());
    }
}
