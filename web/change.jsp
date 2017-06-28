<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="changeEmp" method="post" enctype="multipart/form-data">
            <input type="text" name="empid" value="${emp.empid}" readonly="readonly" />
            <input type="text" name="ename" value="${emp.ename}" />
            <input type="date" name="hiredate" value="${emp.hiredate}" />
            <input type="file" name="photo1"  />
            <input type="submit" value="保存"/>
        </form>
    </div>
</body>
</html>
