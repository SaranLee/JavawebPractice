<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/8
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注 册</title>
</head>
<body>
<form action="${PATH}/signup">
    <label for="username">用户名：</label><input type="text" name="username" id="username"> <br>
    <label for="password">密&nbsp&nbsp码：</label><input type="password" name="password" id="password"> <br>
    <%--<label for="username">确认密码：</label><input type="text">--%>
    <label for="role">身&nbsp&nbsp份：</label>
    <select id="role" name="role">

    </select> <br>
    <button type="button" href="${PATH}/user/roles" id="submit">注&nbsp&nbsp册</button> <br>
</form>

<form action="${PATH}/user/uploadAvatar" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile">
    <input type="submit" value="上传">
</form>
</body>
</html>
<script src="${PATH}/static/js/jquery-1.12.4.min.js"></script>
<script>
    $(function () {
        var roleList;
        $.ajax({
            url:"${PATH}/user/roles",
            type:"get",
            dataType:"json",
            success:function (rtn) {
                console.info(rtn);
                roleList = rtn;
                $(roleList).each(function (i, role) {
                    $("#role").append("<option value='" + role + "'>" + role + "</option>");
                });
                $("#role").val("学生");
            },
            error:function () {
                console.info("失败了");
            }
        });
    });
</script>
