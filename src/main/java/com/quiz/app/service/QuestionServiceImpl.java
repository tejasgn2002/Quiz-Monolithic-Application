package com.quiz.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.entity.Question;
import com.quiz.app.mapper.QuestionMapper;
import com.quiz.app.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	private final QuestionRepository questionRepo;
	private final QuestionMapper questionMapper;
	
	public QuestionServiceImpl(QuestionRepository questionRepo,QuestionMapper questionMapper) {
		this.questionRepo = questionRepo;
		this.questionMapper = questionMapper;
	}

	@Override
	public List<QuestionDto> fetchAllQuestions() {
		return questionRepo.findAll()
				.stream()
				.map(s -> questionMapper.toDto(s))
				.toList();
	}

	@Override
	public List<QuestionDto> fetchAllQuestionsByCategory(String category) {
		return questionRepo.findAllByCategory(category)
						.stream()
						.map(s -> questionMapper.toDto(s))
						.toList();
	}

	@Override
	public Question addQuestion(QuestionDto questionDto) {
		Question question = questionMapper.toEntity(questionDto);
		return questionRepo.save(question);
	}
	
	
	
	
}
