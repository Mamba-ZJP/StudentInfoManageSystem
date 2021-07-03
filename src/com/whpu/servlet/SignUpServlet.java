package com.whpu.servlet;

import com.alibaba.fastjson.JSON;
import com.whpu.dao.UserDao;
import com.whpu.dao.UserDaoImplement;
import com.whpu.entity.Response;
import com.whpu.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet implements Servlet {
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

        String loginType = request.getParameter("loginType");
        Response result = new Response();
        response.setContentType("application/json;charset=utf-8");


        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        int status = Integer.parseInt(request.getParameter("status"));

        user.setAll(username, password, phone, status);

        UserDao userDao = new UserDaoImplement();
        try {
            userDao.addUser(user);
            result.setAll(200, null, "操作成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setAll(404, null, "操作失败！");
            response.getWriter().print(JSON.toJSONString(result));
        }
        response.getWriter().print(JSON.toJSONString(result));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
