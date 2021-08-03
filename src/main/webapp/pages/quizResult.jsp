<%--
  Created by IntelliJ IDEA.
  User: qiumin
  Date: 8/3/21
  Time: 3:42 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
<div class="container mt-2">
    <div style="display: inline-block;">
        <label>Quiz Name:</label>
        <label>${sessionScope.quiz.name}</label>
    </div>
    <div style="display: inline-block;">
        <label>User Name:</label>
        <label>${sessionScope.user.name}</label>
    </div>
    <div style="display: inline-block;">
        <label>Start Time:</label>
        <label>${sessionScope.startTime}</label>
    </div>
    <div style="display: inline-block;">
        <label>End Time:</label>
        <label>${sessionScope.endTime}</label>
    </div>
    <div class="question bg-white p-3 border-bottom">
        <c:forEach items="${sessionScope.quizResult.questions}" var="question" varStatus="questionStatus">
            <div class="d-flex flex-row align-items-center question-title">
                <h3 class="text-danger">Q.</h3>
                <h5 class="mt-1 ml-2">${question.description}</h5>
            </div>
            <c:forEach items="${question.choices}" var="choice" varStatus="choiceStatus">
                <div>
                    <label class="radio">
                        <label>
                            <span>${choice.description}</span>
                            <c:if test="${question.selectIdx == choice.id}">
                                <span>Your Answer</span>
                            </c:if>
                            <c:if test="${choice.answer == 1}">
                                <span>Correct Answer</span>
                            </c:if>
                        </label>
                    </label>
                </div>
            </c:forEach>
        </c:forEach>
    </div>
    <div style="display: inline-block;">
        <label>Pass:</label>
        <label>${sessionScope.isPass==1?"Passed":"Failed"}</label>
    </div>
    <div style="display: inline-block;">
        <a href="../home.jsp">Take another quiz</a>
    </div>
</div>
</body>
</html>
