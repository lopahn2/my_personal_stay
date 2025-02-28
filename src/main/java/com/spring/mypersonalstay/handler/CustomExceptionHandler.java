package com.spring.mypersonalstay.handler;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ch.qos.logback.classic.Logger;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException e) {

		return ErrorResponseEntity.toResponseEntity(e.getAuthCode());
	}

}