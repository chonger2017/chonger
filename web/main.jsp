<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div>
        <form action="findLikeName">
            <input type="text" name="name" />
            <input type="submit" value="查询"/>
        </form>
    </div>
    <div align="center" >
        <table  border="1">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>日期</td>
                <td>照片</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${list}" var="emp">
                <tr>
                    <td>${emp.empid}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.hiredate}</td>
                    <td><img src="images/${emp.photo}"/></td>
                    <td><input type="button" value="修改" onclick="window.location.href='goChangeUI?empid=${emp.empid}'" /></td>
                    <td><input type="button" value="删除" onclick="window.location.href='delEmp?empid=${emp.empid}'"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <input type="button" onclick="window.location.href='goAddEmpUI'" />
    </div>
</body>
</html>
