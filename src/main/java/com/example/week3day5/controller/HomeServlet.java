package com.example.week3day5.controller;

import com.example.week3day5.domain.AllHomeResponse;
import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.Quiz;
import com.example.week3day5.service.QuizService;
import com.example.week3day5.service.impl.QuizServiceImple;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private QuizService quizService;

    public void init() {
        this.quizService = new QuizServiceImple();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllHomeResponse allHomeResponse = new AllHomeResponse();
        List<Quiz> quizzes = quizService.getAllQuizzes();
        Gson gson = new Gson();
        request.getSession().setAttribute("quizzes",quizzes);
        allHomeResponse.setQuizzes(quizzes);
        allHomeResponse.setRedirectUrl(request.getContextPath()+"/home.jsp");
        prepareAllQuizResponse(allHomeResponse, true, "");
        PrintWriter writer = response.getWriter();
        String addResponseJson = gson.toJson(allHomeResponse);
        writer.append(addResponseJson);
        writer.close();
    }

    private void prepareAllQuizResponse(AllHomeResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }
}
