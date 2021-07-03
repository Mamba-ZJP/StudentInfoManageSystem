package com.whpu.servlet;

import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.entity.Response;
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
        String password = request.getParameter("password");

        int gradeid = Integer.parseInt(request.getParameter("gradeid"));
        int score = Integer.parseInt(request.getParameter("score"));
        int status = Integer.parseInt(request.getParameter("status"));

        Student student = new Student(sid, sname, sno, gradeid, address, score, password, status);
        System.out.println("sid = " + sid);
        Response result = new Response();

        try {
            studentDao.updateStu(student);
        } catch (SQLException e) {
            e.printStackTrace();
            result.setAll(404, null, "操作失败");
        }

        String loginType = request.getParameter("loginType");
        response.sendRedirect("selectAll?loginType=" + loginType);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
