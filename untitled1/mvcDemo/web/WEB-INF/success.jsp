<%@ page import="scu.demo.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Lee Saran
  Date: 2020/12/24
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%
    List<User> users = (List<User>) request.getAttribute("allUsers");
    Iterator<User> itr = users.iterator();
%>
<h3>以下是全部用户</h3>
<ul>
    <%
        while (itr.hasNext()) {
    %>
    <li>
        <%= itr.next().getUsername()%>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>
