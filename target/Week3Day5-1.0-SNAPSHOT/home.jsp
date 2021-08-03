<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/home.js"></script>
    <title>Home Page</title>
</head>
<body>
<jsp:include page="/pages/nav.jsp" flush="true"/>
<div container mt-2>
    <c:forEach items="${sessionScope.quizzes}" var="quiz" varStatus="quizStatus">
        <h1><a href="javascript:void(0);" onclick="js_method(${quiz.id})">${quiz.name}</a></h1>
    </c:forEach>
</div>
</body>
</html>