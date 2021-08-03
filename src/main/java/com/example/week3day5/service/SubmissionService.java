package com.example.week3day5.service;

import com.example.week3day5.entity.Quiz;

import java.util.Map;

public interface SubmissionService {
    int addSubmission(String startTime, String endTime, int userId, Quiz quiz, int isPass);
    Map<String, Integer> getQuizTypeIds(int userId);
}
