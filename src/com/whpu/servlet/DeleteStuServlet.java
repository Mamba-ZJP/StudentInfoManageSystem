package com.whpu.servlet;

import com.whpu.dao.StudentDao;
import com.whpu.dao.StudentDaoImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        // 获取学生表的编号
        Integer id = Integer.parseInt(req.getParameter("sid"));
        StudentDao studentDao = new StudentDaoImplement();
        studentDao.deleteStu(id);
        resp.sendRedirect("all");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
