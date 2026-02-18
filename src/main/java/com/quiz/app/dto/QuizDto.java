package com.quiz.app.dto;

import java.util.List;


public class QuizDto {
	private Integer id;
	private String title;
	private List<QuestionDto> questionsDto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<QuestionDto> getQuestionsDto() {
		return questionsDto;
	}
	public void setQuestionsDto(List<QuestionDto> questionsDto) {
		this.questionsDto = questionsDto;
	}
}
