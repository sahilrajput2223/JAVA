package com.sahil.spring.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {NotFoundException.class})
	public final ResponseEntity<customErrorResponce> handleAnyException(Exception e, WebRequest request){
		customErrorResponce customErrorResponce = new customErrorResponce("Not Found ERROR" , e.getMessage());
		customErrorResponce.setLocalDateTime(LocalDateTime.now());
		customErrorResponce.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<customErrorResponce>(customErrorResponce, HttpStatus.NOT_FOUND);
	}
}
