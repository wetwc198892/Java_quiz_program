package com.example.week3day5.domain;

import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.User;

public class AllUsersResponse {
    private ServiceStatus serviceStatus;
    private User user;
    private String redirectUrl;

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
