package com.quiz.app.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuestionsListDto;
import com.quiz.app.dto.QuizDto;
import com.quiz.app.dto.SubmitResponseDto;
import com.quiz.app.entity.Question;
import com.quiz.app.entity.Quiz;
import com.quiz.app.exceptions.QuizNotFoundException;
import com.quiz.app.mapper.QuestionsListMapper;
import com.quiz.app.mapper.QuizMapper;
import com.quiz.app.repository.QuestionRepository;
import com.quiz.app.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService{
	
	private final QuizRepository quizRepo;
	private final QuestionRepository questionRepo;
	private final QuizMapper quizMapper;
	private final QuestionsListMapper questionsListMapper;
	
	public QuizServiceImpl(QuizRepository quizRepo,
			QuestionRepository questionRepo,
			QuizMapper quizMapper,
			QuestionsListMapper questionsListMapper) {
		this.quizRepo = quizRepo;
		this.questionRepo = questionRepo;
		this.quizMapper = quizMapper;
		this.questionsListMapper = questionsListMapper;
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
	public List<QuestionsListDto> getQuizQuestions(int id) {
		Quiz quiz = quizRepo.findById(id).orElseThrow(
				() -> new QuizNotFoundException("Quiz Not Found")
				);
		
		List<QuestionsListDto> questionsListDto = quiz.getQuestions()
												.stream()
												.map(q -> questionsListMapper.toDto(q))
												.toList();
		return questionsListDto;
	}

	@Override
	public Integer submitedQuiz(Integer id, List<SubmitResponseDto> submitReponseDto) {
		Quiz quiz = quizRepo.findById(id).orElseThrow(
				() -> new QuizNotFoundException("Quiz Not Found")
				);
		Map<Integer,String> rightAnswer = quiz.getQuestions()
												.stream()
												.collect(Collectors.toMap(Question::getId, Question::getRightAnswer));
		Integer total = 0;
		for(SubmitResponseDto responseDto : submitReponseDto) {
			if(responseDto.getResponse().equals(rightAnswer.get(responseDto.getId()))) {
				total++;
			}
		}
		return total;
	}
	
	
	
}
