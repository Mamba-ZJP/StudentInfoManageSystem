<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/7/2
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    添加页面
    <form action="/add">
        姓名：
        <input type="text" name="sname" value=""/><br>
        学号：
        <input type="text" name="sno" value=""/><br>
        班级：
        <input type="text" name="gradeid" value=""/><br>
        地址：
        <input type="text" name="address" value=""/><br>
        成绩：
        <input type="text" name="score" value=""/><br>
        密码：
        <input type="text" name="password" value=""/><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
