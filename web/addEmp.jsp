<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.validate.js"/>
    <script type="text/javascript" src="js/jquery-3.2.1.js" />
    <script type="text/javascript" language="JavaScript">
        $().ready(function() {
                $("#form").validate({
                    rules:{
                        ename:{
                            required:true,
                            minlength:5
                        }
                    }
                    ,messages:{
                        ename:"长度至少5位，必填"
                    }
                });
            });
    </script>
</head>
<body>
<div>
    <form id="form" action="addEmp" method="post" enctype="multipart/form-data">
        <input type="text" name="empid" value="${empid}" readonly="readonly"/><br/>
        <input type="text" name="ename"  /><br/>
        <input type="date" name="hiredate" /><br/>
        <input type="file" name="photo1" /><br/>
        <input type="submit" value="保存"/>
    </form>
</div>
</body>
</html>
