package com.example.week3day5.service;

import com.example.week3day5.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz getQuestion(int quizId);
    List<Quiz> getAllQuizzes();
}
