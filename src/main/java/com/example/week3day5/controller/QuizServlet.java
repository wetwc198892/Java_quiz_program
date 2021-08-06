package com.example.week3day5.controller;

import com.example.week3day5.domain.AllQuizResponse;
import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.Question;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "quizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {
    private QuizService quizService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
    public void init() {
        this.quizService = new QuizServiceImple();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllQuizResponse allQuizResponse = new AllQuizResponse();
        Gson gson = new Gson();
        Quiz quiz;
        if (request.getSession().getAttribute("quiz") == null) {
            quiz = quizService.getQuestion(Integer.parseInt(request.getParameter("quizId")));
            request.getSession().setAttribute("startTime",sdf.format(new Date()));
            Date date = new Date();
            int min = date.getMinutes();
            date.setMinutes(min+15);
            request.getSession().setAttribute("endTime",sdf.format(date));
            if (quiz == null || quiz.getName() == null) {
                prepareAllQuizResponse(allQuizResponse, false, "Quiz not exist");
            } else {
                request.getSession().setAttribute("curPage", 1);
                request.getSession().setAttribute("totalSize", quiz.getQuestions().size());
                request.getSession().setAttribute("quiz", quiz);
                request.getSession().setAttribute("question", quiz.getQuestions().get(0));
                allQuizResponse.setRedirectUrl(request.getContextPath() + "/pages/quiz.jsp");
                prepareAllQuizResponse(allQuizResponse, true, "");
            }
        } else {
            quiz = (Quiz) request.getSession().getAttribute("quiz");
            if (request.getParameter("selectIdx") != null) {
                Question question = quiz.getQuestions().get(Integer.parseInt(request.getParameter("prevPage")) - 1);
                question.setSelectIdx(Integer.parseInt(request.getParameter("selectIdx")));
                quiz.getQuestions().set(Integer.parseInt(request.getParameter("prevPage")) - 1, question);
            }
            request.getSession().setAttribute("curPage", Integer.parseInt(request.getParameter("curPage")));
            request.getSession().setAttribute("question", quiz.getQuestions().get(Integer.parseInt(request.getParameter("curPage")) - 1));
            allQuizResponse.setRedirectUrl(request.getContextPath() + "/pages/quiz.jsp");
            prepareAllQuizResponse(allQuizResponse, true, "");
        }
        PrintWriter writer = response.getWriter();
        String addResponseJson = gson.toJson(allQuizResponse);
        writer.append(addResponseJson);
        writer.close();
    }

    private void prepareAllQuizResponse(AllQuizResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }
}
