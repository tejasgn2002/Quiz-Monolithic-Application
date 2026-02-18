package com.quiz.app.service;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.quiz.app.dto.QuizDto;
import com.quiz.app.entity.Question;

public interface QuizService {
	QuizDto createQuiz(String category,String title,Integer numOfQuestions);
	List<Question> getQuizQuestions(int id);
}
