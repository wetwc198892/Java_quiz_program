package com.example.week3day5.service.impl;

import com.example.week3day5.dao.SubmissionDAO;
import com.example.week3day5.entity.Quiz;
import com.example.week3day5.service.SubmissionService;

import java.util.Map;

public class SubmissionServiceImpl implements SubmissionService {
    private SubmissionDAO submissionDAO;

    public SubmissionServiceImpl() {
        if (submissionDAO == null) submissionDAO = new SubmissionDAO();
    }
    @Override
    public int addSubmission(String startTime, String endTime, int userId, Quiz quiz,int isPass) {
        return submissionDAO.addSubmission(startTime,endTime,quiz.getId(),userId,isPass);
    }

    @Override
    public Map<String, Integer> getQuizTypeIds(int userId) {
        return submissionDAO.getQuizTypeId(userId);
    }
}
