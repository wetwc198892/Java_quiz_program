package com.example.week3day5.domain.common;

public class ServiceStatus {
    private String statusCode;
    private boolean success;
    private String errorMessage;

    public ServiceStatus(String statusCode, boolean success, String errorMessage) {
        this.statusCode = statusCode;
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
