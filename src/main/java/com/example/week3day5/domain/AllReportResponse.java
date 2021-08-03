package com.example.week3day5.domain;

import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.Question;

import java.util.List;

public class AllReportResponse {
    private ServiceStatus serviceStatus;
    private String quizName;
    private String userName;
    private String startTime;
    private String endTime;
    private List<Question> questions;
    private short pass;
    private String redirectUrl;

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public short getPass() {
        return pass;
    }

    public void setPass(short pass) {
        this.pass = pass;
    }
}
