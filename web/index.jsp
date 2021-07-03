<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/29
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
  </head>
  <body>
    <form action="/reg">
      用户名：
      <input type="text" name="username" required> <br>
      密 码：
      <input type="text" name="password" required> <br>

      登录类型：
      <input type="radio" name="loginType" value="学生"/>学生用户
      <input type="radio" name="loginType" value="管理员"/>管理员 <br>

      <input type="submit" value="登录">
    </form>
  </body>
</html>
