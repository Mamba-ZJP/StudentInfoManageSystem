<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/6/30
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    学生查询页面
    ${studentList}
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>学号</td>
            <td>班级</td>
            <td>地址</td>
            <td>成绩</td>
        </tr>
        <%--循环展示信息 items表示数据源（一般都是集合） s表示每个对象--%>
        <c:forEach items="${studentList}" var="s">
            <tr>
                <td>${s.sid}</td>
                <td>${s.sname}</td>
                <td>${s.sno}</td>
                <td>${s.gradeid}</td>
                <td>${s.address}</td>
                <td>${s.score}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
