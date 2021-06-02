package com.sahil.Spring_Boot_REST.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({ "rawtypes", "unchecked" })
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception exception, WebRequest request) {
		List<String> exceptionDetails = new ArrayList<>();
		exceptionDetails.add(exception.getLocalizedMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "Not Found",
				exceptionDetails);
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<Object> handleNoSuchElementException(Exception exception, WebRequest request) {
		List<String> exceptionDetails = new ArrayList<>();
		exceptionDetails.add(exception.getLocalizedMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "User Not Found",
				exceptionDetails);
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
		List<String> exceptionDetails = new ArrayList<>();
		exceptionDetails.add(exception.getLocalizedMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Internal Server Error", exceptionDetails);
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> exceptionDetails = new ArrayList<>();

		exceptionDetails.add(ex.getLocalizedMessage());

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),
				"Server did not understand the request", exceptionDetails);
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> exceptionDetails = new ArrayList<>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			exceptionDetails.add(error.getDefaultMessage());
		}

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "Validation Faild",
				exceptionDetails);
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
