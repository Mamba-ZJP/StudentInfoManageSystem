<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/7/1
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    修改页面
    <%--配置上下文--%>
    <form action="${pageContext.request.contextPath}/updateSubmit">
        编号：
        <input type="text" name="sid" value="${student.sid}" readonly/><br>
        姓名：
        <input type="text" name="sname" value="${student.sname}"/><br>
        学号：
        <input type="text" name="sno" value="${student.sno}"/><br>
        班级：
        <input type="text" name="gradeid" value="${student.gradeid}"/><br>
        地址：
        <input type="text" name="address" value="${student.address}"/><br>
        成绩：
        <input type="text" name="score" value="${student.score}"/><br>
        密码：
        <input type="text" name="password" value="${student.password}"/><br>
        <input type="submit" value="保存修改">
    </form>
</body>
</html>
