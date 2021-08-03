package com.example.week3day5.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    int addReport(int submissionId, List<Integer> questionIds, Map<Integer,Integer> selectIds, Map<Integer,Integer> answerIds);
}
