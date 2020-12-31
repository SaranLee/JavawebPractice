<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/24
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登 录</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    System.out.println("msg = " + msg);
    if(msg == null)
        msg = "";
%>
    <form action="http://localhost:8080/mvcDemo/login">
        <input type="text" dName="username"> <br>
        <input type="password" dName="password"> <br>
        <span style="color: red; font-size: 10px"><%=msg%></span> <br>
        <button type="submit">登&nbsp&nbsp录</button>
    </form>
</body>
</html>
