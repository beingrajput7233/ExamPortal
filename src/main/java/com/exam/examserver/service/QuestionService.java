package com.exam.examserver.service;
import java.util.*;
import com.exam.examserver.entity.quiz.Question;
import com.exam.examserver.entity.quiz.Quiz;

public interface QuestionService {
    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);
}
