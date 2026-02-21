package com.quiz.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.dto.CreateQuizDto;
import com.quiz.app.dto.QuestionsListDto;
import com.quiz.app.dto.QuizDto;
import com.quiz.app.dto.SubmitResponseDto;
import com.quiz.app.entity.Question;
import com.quiz.app.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	private final QuizService service;
	
	public QuizController(QuizService service) {
		this.service = service;
	}
	
	@PostMapping("create")
	public ResponseEntity<QuizDto> createQuiz(@RequestBody CreateQuizDto quiz){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.createQuiz(quiz.getCategory(), quiz.getTitle(), quiz.getNoOfQuestions()));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<QuestionsListDto>> getQuizQuestions(@PathVariable int id){
		return ResponseEntity.ok(service.getQuizQuestions(id));
	}
	
	@GetMapping("submit/{id}")
	public ResponseEntity<Integer> submitedQuiz(@PathVariable Integer id,@RequestBody List<SubmitResponseDto> submitReponseDto){
		return ResponseEntity.ok(service.submitedQuiz(id,submitReponseDto));
	}
}
