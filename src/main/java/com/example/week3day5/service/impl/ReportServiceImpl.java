package com.example.week3day5.service.impl;

import com.example.week3day5.dao.ReportDAO;
import com.example.week3day5.service.ReportService;

import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private ReportDAO reportDAO;

    public ReportServiceImpl() {
        if(reportDAO == null)reportDAO = new ReportDAO();
    }

    @Override
    public int addReport(int submissionId, List<Integer> questionIds, Map<Integer, Integer> selectIds, Map<Integer, Integer> answerIds) {
        return reportDAO.addReport(submissionId,questionIds,selectIds,answerIds);
    }
}
