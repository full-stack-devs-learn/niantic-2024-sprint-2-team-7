package com.niantic.controllers.apis;


import com.niantic.models.Answer;
import com.niantic.models.Question;
import com.niantic.services.AnswerDao;
import com.niantic.services.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class QuestionApiController {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private AnswerDao answerDao;

    @GetMapping(path = "/api/quizzes/{quizId}/question/{questionNumber}")
    public Question getQuestionByQuestionNumber(@PathVariable int quizId, @PathVariable int questionNumber) {
        Question question = questionDao.getQuestion(quizId, questionNumber);
        ArrayList<Answer> answers = answerDao.getAnswersByQuestionId(question.getQuestionId());
        question.setAnswers(answers);
        return question;
    }

}
