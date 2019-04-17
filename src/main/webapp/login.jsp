<%--
  Created by IntelliJ IDEA.
  User: Marcus
  Date: 2019-04-16
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    if(request.getParameter("username") != null && request.getParameter("password") != null){

        if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")) {

            response.sendRedirect("profile.jsp");

    }
}; %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="POST" action="login.jsp">

    <label for="username">Username</label>
    <input id="username" name="username" type="text">
    <br>

    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <br>

    <input type="submit">
</form>

</body>
</html>
