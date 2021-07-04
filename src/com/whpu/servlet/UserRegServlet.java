package com.whpu.servlet;

import com.alibaba.fastjson.JSON;
import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.dao.UserDao;
import com.whpu.dao.UserDaoImplement;
import com.whpu.entity.Response;
import com.whpu.entity.Student;
import com.whpu.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserRegServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet值行操作");
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 获取前端页面 表单中input标签name属性所在的值，需要提供name名称
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        // 响应页面结果
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("application/json;charset=utf-8");

        // 根据输入的用户名和密码，数据库中查询是否存在该用户
        String loginType = request.getParameter("loginType");
        UserDao userDao = new UserDaoImplement();
        StudentDao studentDao = new StudentDaoImplement();
        Response result = new Response();

        try {
            User user = userDao.login(username, password); // 实参
            if (user != null && loginType.equals("user")) { // object默认为null
                result.setAll(200, user, "管理员成功登录!");
            } else if (loginType.equals("user")) {
                result.setAll(404, null, "管理员登录失败!");
            }

            Student student = studentDao.login(username, password);
            if (loginType.equals("student") && student != null) {
                result.setAll(200, student, "学生登录成功!");
            } else if (loginType.equals("student")) {
                result.setAll(404, student, "学生登录失败!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            response.getWriter().print(JSON.toJSONString(result));
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet消亡");
    }
}
