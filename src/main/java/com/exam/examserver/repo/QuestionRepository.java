package com.exam.examserver.repo;

import com.exam.examserver.entity.quiz.Question;
import com.exam.examserver.entity.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    Set<Question> findByQuiz(Quiz quiz);
}
