package com.example.week3day5.controller;

import com.example.week3day5.domain.AllFeedbackResponse;
import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.User;
import com.example.week3day5.service.FeedbackService;
import com.example.week3day5.service.SubmissionService;
import com.example.week3day5.service.impl.FeedbackServiceImpl;
import com.example.week3day5.service.impl.SubmissionServiceImpl;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "feedbackServlet", value = "/feedback")
public class FeedbackServlet extends HttpServlet {
    private SubmissionService submissionService;
    private FeedbackService feedbackService;

    public void init() {
        this.submissionService = new SubmissionServiceImpl();
        this.feedbackService = new FeedbackServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllFeedbackResponse allFeedbackResponse = new AllFeedbackResponse();
        User user = (User) request.getSession().getAttribute("user");
        Map<String, Integer> quizTypeIds = submissionService.getQuizTypeIds(user.getId());
        request.getSession().setAttribute("quizTypeIds", quizTypeIds);
        prepareAllFeedbackResponse(allFeedbackResponse, true, "");
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        String addResponseJson = gson.toJson(allFeedbackResponse);
        writer.append(addResponseJson);
        writer.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllFeedbackResponse allFeedbackResponse = new AllFeedbackResponse();
        int res = feedbackService.addFeedback(Integer.parseInt(request.getParameter("quizTypeId")), Integer.parseInt(request.getParameter("rating")), request.getParameter("feedback"));
        if(res>0){
            prepareAllFeedbackResponse(allFeedbackResponse, true, "");
        }else{
            prepareAllFeedbackResponse(allFeedbackResponse, false, "Add Feedback Failed");
        }
        allFeedbackResponse.setRedirectUrl(request.getContextPath()+"/home.jsp");
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        String addResponseJson = gson.toJson(allFeedbackResponse);
        writer.append(addResponseJson);
        writer.close();
    }

    private void prepareAllFeedbackResponse(AllFeedbackResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }

}
