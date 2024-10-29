package com.nit.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nit.employee.model.AppError;

@ControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<AppError> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		AppError error = new AppError();
		return new ResponseEntity<AppError>(error, HttpStatus.NOT_FOUND);
	}
	
	//@ExceptionHandler(value = Exception.class)
	public ResponseEntity<AppError> handleException(Exception ex){
		AppError error = new AppError();
		return new ResponseEntity<AppError>(error, HttpStatus.NOT_FOUND);
	}
}
