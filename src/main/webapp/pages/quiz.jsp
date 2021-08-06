<%--
  Created by IntelliJ IDEA.
  User: qiumin
  Date: 8/1/21
  Time: 11:40 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="../js/quiz.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/quiz.css">
    <title>Quiz Page</title>
</head>
<script>
    var target = new Date();
    var min = target.getMinutes();
    target.setMinutes(min + 15);
    var countDownDate = target.getTime();
    // Update the count down every 1 second
    var x = setInterval(function () {
        // Get today's date and time
        var now = new Date().getTime();
        // Find the distance between now and the count down date
        var distance = countDownDate - now;
        // Time calculations for days, hours, minutes and seconds
        var days = Math.floor(distance / (1000 * 60 * 60 * 24));
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

        // Output the result in an element with id="demo"
        document.getElementById("timer").innerHTML = minutes + "m " + seconds + "s ";
        // If the count down is over, write some text
    }, 1000);
</script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/quiz.js"></script>
<body>
<div>
    <div class="container mt-5">
        <p id="timer"></p>
        <div class="d-flex justify-content-center row">
            <div class="col-md-10 col-lg-10">
                <div class="border">
                    <div class="question bg-white p-3 border-bottom">
                        <div class="d-flex flex-row justify-content-between align-items-center mcq">
                            <h4>${sessionScope.quiz.name}</h4>
                            <span>(${sessionScope.curPage} of ${sessionScope.totalSize})</span>
                        </div>
                    </div>
                    <div class="question bg-white p-3 border-bottom">
                        <div class="d-flex flex-row align-items-center question-title">
                            <h3 class="text-danger">Q.${sessionScope.curPage}</h3>
                            <h5 class="mt-1 ml-2">${sessionScope.question.description}</h5>
                        </div>
                        <c:forEach items="${sessionScope.question.choices}" var="choice" varStatus="quizStatus">
                            <div>
                                <label class="radio"> <input type="radio" name="choice" value="${choice.id}"
                                    ${sessionScope.question.selectIdx==choice.id ? 'checked':''}>
                                    <span>${choice.description}</span>
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="d-flex flex-row justify-content-between align-items-center p-3 bg-white">
                        <nav style="text-align: center">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${sessionScope.totalSize}" varStatus="loop">
                                    <c:set var="active" value="${loop.index==sessionScope.curPage?'active':''}"/>
                                    <li class="${active}"><a href="javascript:void(0);"
                                                             onclick="buttonClick(${sessionScope.curPage},${loop.index},${sessionScope.totalSize})">${loop.index}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                    <div class="d-flex flex-row justify-content-between align-items-center p-3 bg-white">
                        <button class="btn btn-primary d-flex align-items-center btn-danger" type="button"
                                style="${(Integer.parseInt(String.valueOf(sessionScope.curPage))) > 1 ? 'visibility:visible' : 'visibility:hidden'}"
                                onclick="buttonClick(${sessionScope.curPage},${sessionScope.curPage}-1,${sessionScope.totalSize});">
                            <i
                                    class="fa fa-angle-left mt-1 mr-1"></i>&nbsp;previous
                        </button>
                        <button class="btn btn-primary border-success align-items-center btn-success" type="button"
                                style="${(Integer.parseInt(String.valueOf(sessionScope.curPage))) < (Integer.parseInt(String.valueOf(sessionScope.totalSize))) ? 'visibility:visible' : 'visibility:hidden'}"
                                onclick="buttonClick(${sessionScope.curPage},${sessionScope.curPage}+1,${sessionScope.totalSize});">
                            Next<i
                                class="fa fa-angle-right ml-2"></i></button>

                    </div>
                    <button type="submit" class="btn btn-primary d-flex align-items-center" style="..." id="submit"
                            onclick="submit()">Submit
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
