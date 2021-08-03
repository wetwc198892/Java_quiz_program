package com.example.week3day5.service.impl;

import com.example.week3day5.dao.FeedbackDAO;
import com.example.week3day5.service.FeedbackService;

public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackDAO feedbackDAO;

    public FeedbackServiceImpl() {
        if(feedbackDAO == null)feedbackDAO = new FeedbackDAO();
    }
    @Override
    public int addFeedback(int quizTypeId, int rating, String feedback) {
        return feedbackDAO.addFeedback(quizTypeId,rating,feedback);
    }
}
