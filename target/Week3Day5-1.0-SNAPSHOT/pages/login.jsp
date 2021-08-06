<%--
  Created by IntelliJ IDEA.
  User: qiumin
  Date: 8/1/21
  Time: 12:08 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="../js/login.js"></script>
    <title>Login Page</title>
</head>
<body>
<jsp:include page="/pages/nav.jsp" flush="true"/>
<div class="container mt-2">
    <form method="post">
        <div class="form-group">
            <label for="userName">User Name</label>
            <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password" name="password">
        </div>
        <button type="submit" class="btn btn-primary" id="login">Login</button>
        <button type="button" class="btn btn-primary" id="register" onClick="window.location.href='register.jsp'">Register</button>
    </form>
    <small id="credentialError" style="color: red"></small>
</div>
</body>
</html>
