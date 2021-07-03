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
        String sql = "SELECT * FROM student WHERE gradeid = (SELECT gradeid FROM student WHERE sname=?) and status=1";
        List<Student> studentList = qr.query(sql, new BeanListHandler<Student>(Student.class), name);
        return studentList;
    }

    @Override
    public Student login(String name, String pwd) throws SQLException {
        String sql = "select * from student where sname=? and password=? and status=1";
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

    @Override
    public List<Student> selectAllStu() throws SQLException {
        String sql = "SELECT * FROM student where status=1";
        return qr.query(sql, new BeanListHandler<Student>(Student.class));
    }

    @Override
    public void addStu(Student student) throws SQLException {
        String sql = "INSERT INTO student(sname, sno, gradeid, address, score, PASSWORD) values(?, ?, ?, ?, ?, ?)";
        qr.insert(sql, new BeanListHandler<Student>(Student.class), student.getSname(), student.getSno(),
                student.getGradeid(), student.getAddress(), student.getScore(), student.getPassword());
    }

    @Override
    public void deleteStu(Integer id) {
        String sql = "UPDATE student SET status=0 WHERE sid=?";
        try {
            qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
