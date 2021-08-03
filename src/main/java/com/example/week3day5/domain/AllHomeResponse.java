package com.example.week3day5.domain;

import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.Quiz;

import java.util.List;

public class AllHomeResponse {
    private ServiceStatus serviceStatus;
    private List<Quiz> quizzes;
    private String redirectUrl;

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
