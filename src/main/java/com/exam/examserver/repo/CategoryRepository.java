package com.exam.examserver.repo;

import com.exam.examserver.entity.quiz.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
