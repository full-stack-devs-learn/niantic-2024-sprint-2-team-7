package com.niantic.models;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;

public class Quiz
{
    private int quizId;
    @NotEmpty(message="Quiz Title is required")
    private String title;
    private boolean isLive;

    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz()
    {
    }

    public Quiz(int quizId, String title, boolean isLive)
    {
        this.quizId = quizId;
        this.title = title;
        this.isLive = isLive;
    }

    public int getQuizId()
    {
        return quizId;
    }

    public void setQuizId(int quizId)
    {
        this.quizId = quizId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean getIsLive()
    {
        return isLive;
    }

    public void setIsLive(boolean live)
    {
        isLive = live;
    }

    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions)
    {
        this.questions = questions;
    }
}
