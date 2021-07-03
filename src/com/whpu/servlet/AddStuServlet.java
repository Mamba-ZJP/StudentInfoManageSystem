package com.whpu.servlet;

import com.alibaba.fastjson.JSON;
import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;
import com.whpu.entity.Response;
import com.whpu.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddStuServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        HttpServletRequest request = req;
        HttpServletResponse response = resp;

        StudentDao studentDao = new StudentDaoImplement();
        Response result = new Response();

        String sname = req.getParameter("sname");
        String sno = req.getParameter("sno");
        int gradeid = Integer.parseInt(req.getParameter("gradeid"));
        int score = Integer.parseInt(req.getParameter("score"));
        String address = req.getParameter("address");
        String password = req.getParameter("password");

        Student student = new Student(sname, sno, gradeid, address, score, password);
        try {
            studentDao.addStu(student);
        } catch (SQLException e) {
            e.printStackTrace();
            result.setAll(404, null, "操作失败！");
            response.getWriter().print(JSON.toJSONString(result));
        }
        String loginType = req.getParameter("loginType");
        resp.sendRedirect("selectAll?loginType=" + loginType);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
