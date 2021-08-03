package com.example.week3day5.entity;

import java.util.List;

public class Report {
    private int id;
    private Submission submission;
    private List<Question> questions;
    private int answerIdx;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getAnswerIdx() {
        return answerIdx;
    }

    public void setAnswerIdx(int answerIdx) {
        this.answerIdx = answerIdx;
    }
}
