package com.example.week3day5.service.impl;

import com.example.week3day5.dao.QuizDAO;
import com.example.week3day5.entity.Quiz;
import com.example.week3day5.service.QuizService;

import java.util.List;

public class QuizServiceImple implements QuizService {
    private QuizDAO quizDAO;

    public QuizServiceImple() {
        if (quizDAO == null) quizDAO = new QuizDAO();
    }

    @Override
    public Quiz getQuestion(int quizId) {
        return quizDAO.getQuiz(quizId);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizDAO.getAllQuiz();
    }
}
