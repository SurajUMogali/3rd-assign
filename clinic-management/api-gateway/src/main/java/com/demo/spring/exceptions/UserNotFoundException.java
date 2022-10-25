package com.demo.spring.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.spring.util.Message;

public class UserNotFoundException extends Exception {
	@ExceptionHandler
	public ResponseEntity<Message> handleUserNotExistsException(UserNotExistsException ex) {
		return ResponseEntity.ok(new Message("User Not Found"));

	}

}
