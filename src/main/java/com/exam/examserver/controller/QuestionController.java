package com.exam.examserver.controller;

import java.util.*;
import com.exam.examserver.entity.quiz.Question;
import com.exam.examserver.entity.quiz.Quiz;
import com.exam.examserver.service.QuestionService;
import com.exam.examserver.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

//    for getting questions of quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
//        for getting all questions
//        Quiz quiz=new Quiz();
//        quiz.setqId(qid);
//
//        Set<Question> questionsOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

//        For getting number of questions specified for a particular quiz
          Quiz quiz=this.quizService.getQuiz(qid);
          Set<Question> questions=quiz.getQuestions();

          List list=new ArrayList(questions);

          if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
                list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
          }
          Collections.shuffle(list);
          return ResponseEntity.ok(list);
    }

//    for getting a question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion(quesId);
    }

    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);
    }

}
