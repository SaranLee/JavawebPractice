<%@ page import="scu.demo.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
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
    String username = request.getParameter("username");
    if(username == null) { //说明是直接进入main.jsp，不是从login.jsp跳转来的
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        for(Cookie e : cookies){
            if(e.getName().equals("loginUser")){
                flag = true;
                break;
            }
        }
        //没有查到loginUser的cookie，说明之前没登录过，或者登录的cookie时间已过，需要重新登录
        if(!flag){
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }else{
             out.println("<h3 style='color: red'>这是主界面</h3>");
        }
    } else { //是从login.jsp跳转来的
    List<User> users = (List<User>) request.getAttribute("allUsers");
    Iterator<User> itr = users.iterator();
%>
<h3 style="color: red">登录成功</h3>
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
    }
    %>
</ul>
</body>
</html>
