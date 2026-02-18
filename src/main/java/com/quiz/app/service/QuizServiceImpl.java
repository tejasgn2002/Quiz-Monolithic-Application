package com.quiz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuizDto;
import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;
import com.quiz.app.mapper.QuizMapper;
import com.quiz.app.repository.QuestionRepository;
import com.quiz.app.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService{
	
	private final QuizRepository quizRepo;
	private final QuestionRepository questionRepo;
	private final QuizMapper quizMapper;
	
	public QuizServiceImpl(QuizRepository quizRepo,QuestionRepository questionRepo,QuizMapper quizMapper) {
		this.quizRepo = quizRepo;
		this.questionRepo = questionRepo;
		this.quizMapper = quizMapper;
	}

	@Override
	public QuizDto createQuiz(String category, String title, Integer numOfQuestions) {
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		List<Question> questions = questionRepo.findRandomQuestionsByCategory(category,numOfQuestions);
		quiz.setQuestions(questions);
		return quizMapper.toDto(quizRepo.save(quiz));
	}

	@Override
	public List<Question> getQuizQuestions(int id) {
		Quiz quiz = quizRepo.findById(id).orElseThrow();
		return null;
	}
	
	
}
