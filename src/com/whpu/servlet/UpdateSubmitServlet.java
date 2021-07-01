package com.whpu.servlet;

import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.entity.Student;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateSubmitServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取修改页面的学生属性值
        StudentDao studentDao = new StudentDaoImplement();
        String s = request.getParameter("sid");
        int sid = Integer.parseInt(s);

        String sname = request.getParameter("sname");
        String sno = request.getParameter("sno");
        String address = request.getParameter("address");
        s = request.getParameter("gradeid");
        int gradeid = Integer.parseInt(s);

        s = request.getParameter("score");
        int score = Integer.parseInt(s);
        String password = request.getParameter("password");

        Student student = new Student(sid, sname, sno, gradeid, address, score, password);

        try {
            studentDao.updateStu(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
