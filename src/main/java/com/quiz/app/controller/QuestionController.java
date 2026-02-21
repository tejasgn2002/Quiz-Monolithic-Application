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

import com.quiz.app.dto.QuestionDto;
import com.quiz.app.entity.Question;
import com.quiz.app.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	private final QuestionService service;
	
	public QuestionController(QuestionService service) {
		this.service = service;
	}
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<QuestionDto>> fetchAllQuestions(){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAllQuestions());
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<QuestionDto>> fetchAllQuesitonsByCategory(@PathVariable String category){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAllQuestionsByCategory(category));
	}
	
	@PostMapping("add")
	public ResponseEntity<Question> addQuestion(@RequestBody QuestionDto questionDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addQuestion(questionDto));
	}
	
}
