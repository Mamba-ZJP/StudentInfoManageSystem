package com.whpu.servlet;

import com.alibaba.fastjson.JSON;
import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.entity.Response;
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
        response.setContentType("application/json;charset=utf-8");

        List<Student> studentList = null;
        Response result = new Response();
        try {
            studentList = studentDao.selectAllStu();
            result.setAll(200, studentList, "操作成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setAll(200, studentList, "操作失败!");
        }

        String res = JSON.toJSONString(result);
        response.getWriter().print(res);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
