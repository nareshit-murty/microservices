package com.nit.department.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(value = DepartmentNotFoundException.class)
	public ResponseEntity<Error> handleDeparetmentNotFoundException(DepartmentNotFoundException ex) {
		Error error = new Error();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		error.setMessage(ex.getMessage());
		error.setDateOfError(date.toString());
		error.setTimeOfError(time.toString());
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
}