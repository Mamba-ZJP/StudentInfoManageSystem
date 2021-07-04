package com.whpu.servlet;

import com.alibaba.fastjson.JSON;
import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.dao.UserDao;
import com.whpu.dao.UserDaoImplement;
import com.whpu.entity.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ChangePwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        HttpServletRequest request = req;
        HttpServletResponse response = resp;

        Response result = new Response();
        response.setContentType("application/json;charset=utf-8");

        String loginType = request.getParameter("loginType");

        if (loginType.equals("user")) {
            UserDao user = new UserDaoImplement();
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");

            try {
                user.changePwd(username, pwd);
                result.setAll(200, null, "管理员修改密码成功！");
            } catch (SQLException e) {
                e.printStackTrace();
                result.setAll(404, null, "管理员修改密码失败！");
            } finally {
                response.getWriter().print(JSON.toJSONString(result));
            }

        } else if (loginType.equals("student")) {
            StudentDao studentDao = new StudentDaoImplement();
            String sname = request.getParameter("sname");
            String pwd = request.getParameter("password");

            try {
                studentDao.changePwd(sname, pwd);
                result.setAll(200, null,"学生修改密码成功！");
            } catch (SQLException e) {
                e.printStackTrace();
                result.setAll(404, null,"学生修改密码失败！");
            } finally {
                response.getWriter().print(JSON.toJSONString(result));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
