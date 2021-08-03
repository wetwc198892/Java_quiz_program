package com.example.week3day5.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String description;
    private int selectIdx;
    private int answerIdx;
    private List<Choice> choices;

    public Question() {
        choices = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public int getSelectIdx() {
        return selectIdx;
    }

    public void setSelectIdx(int selectIdx) {
        this.selectIdx = selectIdx;
    }

    public int getAnswerIdx() {
        return answerIdx;
    }

    public void setAnswerIdx(int answerIdx) {
        this.answerIdx = answerIdx;
    }
}
