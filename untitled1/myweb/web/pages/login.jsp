<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/24
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String warning = (String) request.getAttribute("warning");
    System.out.println("info: " + warning);
    if(warning == null)
        warning = "";
%>
<form action="http://192.168.0.27:8080/myweb/login">
    <input type="text" dName="username"> <br>
    <input type="password" dName="password"> <br>
    <p style="color: red"><%=warning %></p>
    <button type="submit">登&nbsp&nbsp录</button>
</form>
</body>
</html>
