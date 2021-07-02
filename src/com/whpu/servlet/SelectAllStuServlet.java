package com.whpu.servlet;

import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.entity.Student;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectAllStuServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        StudentDao studentDao = new StudentDaoImplement();

        List<Student> studentList = null;
        try {
            studentList = studentDao.selectAllStu();
            request.setAttribute("studentList", studentList);
            request.getRequestDispatcher("jsp/showInfoAdmin.jsp").forward(request, response);
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
