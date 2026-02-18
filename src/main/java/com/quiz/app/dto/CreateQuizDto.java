package com.quiz.app.dto;

public class CreateQuizDto {
	private String category;
	private Integer noOfQuestions;
	private String title;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(Integer noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
