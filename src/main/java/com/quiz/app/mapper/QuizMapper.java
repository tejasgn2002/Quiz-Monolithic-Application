package com.quiz.app.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.dto.QuizDto;
import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;

@Component
public class QuizMapper {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	public Quiz toEntity(QuizDto dto) {
		Quiz quiz = new Quiz();
		quiz.setId(dto.getId());
		quiz.setTitle(dto.getTitle());
		List<Question> questions = dto.getQuestionsDto().stream()
									.map(q -> questionMapper.toEntity(q))
										.toList();
		quiz.setQuestions(questions);
		return quiz;
	}
	
	public QuizDto toDto(Quiz quiz) {
		QuizDto quizDto = new QuizDto();
		quizDto.setId(quiz.getId());
		quizDto.setTitle(quiz.getTitle());
		List<QuestionDto> questionsDto = quiz.getQuestions().stream()
									.map(q -> questionMapper.toDto(q))
										.toList();
		quizDto.setQuestionsDto(questionsDto);
		return quizDto;
	}
}