package com.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{
}
