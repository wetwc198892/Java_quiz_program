package com.example.week3day5.controller;

import com.example.week3day5.domain.AllReportResponse;
import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.service.ReportService;
import com.example.week3day5.service.impl.ReportServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "reportServlet", value = "/report")
public class ReportServlet extends HttpServlet {
    private ReportService reportService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");

    public void init() {
        this.reportService = new ReportServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllReportResponse allReportResponse = new AllReportResponse();

    }

    private void prepareAllQuizResponse(AllReportResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }
}
