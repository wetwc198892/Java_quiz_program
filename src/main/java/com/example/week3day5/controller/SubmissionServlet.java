package com.example.week3day5.controller;

import com.example.week3day5.domain.AllSubmissionResponse;
import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.Choice;
import com.example.week3day5.entity.Question;
import com.example.week3day5.entity.Quiz;
import com.example.week3day5.entity.User;
import com.example.week3day5.service.ReportService;
import com.example.week3day5.service.SubmissionService;
import com.example.week3day5.service.impl.ReportServiceImpl;
import com.example.week3day5.service.impl.SubmissionServiceImpl;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "submissionServlet", value = "/submission")
public class SubmissionServlet extends HttpServlet {
    private SubmissionService submissionService;
    private ReportService reportService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");

    public void init() {
        this.submissionService = new SubmissionServiceImpl();
        this.reportService = new ReportServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllSubmissionResponse allSubmissionResponse = new AllSubmissionResponse();
        String startTime = (String) request.getSession().getAttribute("startTime");
        int res = 0;
        User user = (User) request.getSession().getAttribute("user");
        Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");
        if (request.getParameter("selectIdx") != null) {
            int curPage = 0;
            if (request.getSession().getAttribute("curPage") != null)
                curPage = (Integer) request.getSession().getAttribute("curPage") - 1;
            Question question = quiz.getQuestions().get(curPage);
            question.setSelectIdx(Integer.parseInt(request.getParameter("selectIdx")));
            quiz.getQuestions().set(curPage, question);
        }
        int isPass = getPass(quiz);
        request.getSession().setAttribute("isPass",isPass);
        String endTime = sdf.format(new Date());
        if (startTime != null) {
            res = submissionService.addSubmission(startTime, endTime, user.getId(), quiz,isPass);
        }
        if (res > 0) {
            prepareAllQuizResponse(allSubmissionResponse, true, "");
            allSubmissionResponse.setRedirectUrl(request.getContextPath() + "/pages/quizResult.jsp");
            List<Integer> questionIds = new ArrayList<>();
            Map<Integer,Integer> selectIds = new HashMap<>();
            Map<Integer,Integer> answerIds = new HashMap<>();
            for(Question question:quiz.getQuestions()){
                questionIds.add(question.getId());
                selectIds.put(question.getId(),question.getSelectIdx());
                for(Choice choice:question.getChoices()){
                    if(choice.getAnswer()==1)answerIds.put(question.getId(),choice.getId());
                }
            }
            reportService.addReport(res,questionIds,selectIds,answerIds);
            request.getSession().setAttribute("quizResult",quiz);
            request.getSession().removeAttribute("quiz");
            request.getSession().removeAttribute("curPage");
        } else {
            prepareAllQuizResponse(allSubmissionResponse, false, "Submission failed");
        }
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        String addResponseJson = gson.toJson(allSubmissionResponse);
        writer.append(addResponseJson);
        writer.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        AllSubmissionResponse allSubmissionResponse = new AllSubmissionResponse();
        int res = 0;
        Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");
        if (request.getParameter("selectIdx") != null) {
            int curPage = 0;
            if (request.getSession().getAttribute("curPage") != null)
                curPage = (Integer)request.getSession().getAttribute("curPage") - 1;
            Question question = quiz.getQuestions().get(curPage);
            question.setSelectIdx(Integer.parseInt(request.getParameter("selectIdx")));
            quiz.getQuestions().set(curPage, question);
        }
        if (!checkAllAnswer(quiz)) {
            allSubmissionResponse.setAllAnswer(0);
        }else{
            allSubmissionResponse.setAllAnswer(1);
        }
        prepareAllQuizResponse(allSubmissionResponse, true, "");
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        String addResponseJson = gson.toJson(allSubmissionResponse);
        writer.append(addResponseJson);
        writer.close();
    }

    private boolean checkAllAnswer(Quiz quiz) {
        for (Question question : quiz.getQuestions()) {
            if (question.getSelectIdx() == 0) return false;
        }
        return true;
    }

    private void prepareAllQuizResponse(AllSubmissionResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }

    private int getPass(Quiz quiz){
        int isPass = 0;
        int count = 0;
        for (Question question : quiz.getQuestions()) {
            for (Choice choice : question.getChoices()) {
                if (choice.getAnswer() == 1 && question.getSelectIdx() == choice.getId()) count++;
            }
        }
        if (count >= 6) isPass = 1;
        return isPass;
    }
}
