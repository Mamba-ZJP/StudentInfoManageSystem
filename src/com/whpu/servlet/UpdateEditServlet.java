package com.whpu.servlet;

import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.entity.Student;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateEditServlet implements Servlet {
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
        String id = request.getParameter("sid");
        StudentDao studentDao = new StudentDaoImplement();

        int i = Integer.parseInt(id);
        System.out.println("i = " +  i);
        Student student = null;
        try {
            student = studentDao.selectOneStuBySid(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("student", student);
        request.getRequestDispatcher("jsp/updateStu.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
