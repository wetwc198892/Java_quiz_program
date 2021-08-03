package com.example.week3day5.domain;

import com.example.week3day5.domain.common.ServiceStatus;

public class AllSubmissionResponse {
    private ServiceStatus serviceStatus;
    private int allAnswer;
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

    public int getAllAnswer() {
        return allAnswer;
    }

    public void setAllAnswer(int allAnswer) {
        this.allAnswer = allAnswer;
    }
}
