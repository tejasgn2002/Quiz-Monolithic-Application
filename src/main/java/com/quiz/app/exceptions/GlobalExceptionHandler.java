package com.quiz.app.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(QuizNotFoundException.class)
	public ResponseEntity<ErrorResponse> quizNotFoundHandler(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now());
		
		return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
	}
}

//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler({
//            IllegalArgumentException.class,
//            MethodArgumentTypeMismatchException.class
//    })
//    public ResponseEntity<ErrorResponse> handleBadRequest(Exception ex) {
//
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                ex.getMessage(),
//                LocalDateTime.now()
//        );
//
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(errorResponse);
//    }
//}
