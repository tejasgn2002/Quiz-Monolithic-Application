package com.quiz.app.service;

import java.util.List;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.entity.Question;

public interface QuestionService {
	List<QuestionDto> fetchAllQuestions();
	List<QuestionDto> fetchAllQuestionsByCategory(String category);
	Question addQuestion(QuestionDto questionDto);
}
