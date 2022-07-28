package com.example.employeemanagement.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptions{
	private static Logger log = LoggerFactory.getLogger(CustomExceptions.class);
	 @ExceptionHandler(value = NoSuchDepartmentException.class)
	    public ResponseEntity<String> NoSuchDepartmentException(NoSuchDepartmentException e) {
	    	log.error("Department with the provided ID does not exist", e);
	        return new ResponseEntity<>("Department Not found" ,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	 @ExceptionHandler(value = NoSuchEmployeeException.class)
	    public ResponseEntity<String> NoSuchEmployeeException(NoSuchEmployeeException e) {
	    	log.error("Employee with the provided ID does not exist", e);
	        return new ResponseEntity<>("Employee Not found" ,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 @ExceptionHandler(value = NoSuchRoleException.class)
	    public ResponseEntity<String> NoSuchRoleException(NoSuchRoleException e) {
	    	log.error("Role with the provided ID does not exist", e);
	        return new ResponseEntity<>("Role Not found" ,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 @ExceptionHandler(value = NoSuchAddressException.class)
	    public ResponseEntity<String> NoSuchAddressException(NoSuchAddressException e) {
	    	log.error("Address with the provided ID does not exist", e);
	        return new ResponseEntity<>("Address Not found" ,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 @ExceptionHandler(value = BadServerRequestException.class)
	    public ResponseEntity<String> BadServerRequestException(BadServerRequestException e) {
	    	log.error("Address with the provided ID does not exist", e);
	        return new ResponseEntity<>("Bad Server Request" ,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}