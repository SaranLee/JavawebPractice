<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/7
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:set var="PATH" value="${pageContext.request.contextPath}" scope="application"/>
  <a href="${pageContext.request.contextPath}/hello">跳转</a>
  <form action="${pageContext.request.contextPath}/hello">
      username:<input type="text" name="username">
      sex:<input type="text" name="sex">
      age:<input type="number" name="age">
      addr:<input type="text" name="addr">
      <input type="submit" value="提交">
  </form>
  <jsp:forward page="WEB-INF/pages/signup.jsp"/>
  </body>
</html>
