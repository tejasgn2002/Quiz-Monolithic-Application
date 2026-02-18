package com.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.app.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findAllByCategory(String category);
	@Query(value = "SELECT * FROM questions WHERE category LIKE ?1 ORDER BY RAND() LIMIT ?2;",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, Integer numOfQuestions);
}
