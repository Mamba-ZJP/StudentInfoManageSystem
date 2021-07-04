package com.whpu.servlet;

import com.alibaba.fastjson.JSON;
import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.entity.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        // 获取学生表的编号
        HttpServletResponse response = resp;

        Integer id = Integer.parseInt(req.getParameter("sid"));
        String loginType = req.getParameter("loginType");

        StudentDao studentDao = new StudentDaoImplement();
        Response result = new Response();
        response.setContentType("application/json;charset=utf-8");

        try {
            studentDao.deleteStu(id);
        } catch (SQLException e) {
            e.printStackTrace();
            result.setAll(404, null, "删除学生失败！");
            response.getWriter().print(JSON.toJSONString(result));
        }

        resp.sendRedirect("selectAll?loginType=" + loginType);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
