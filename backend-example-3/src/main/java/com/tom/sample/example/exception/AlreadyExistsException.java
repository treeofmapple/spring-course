package com.tom.sample.example.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class AlreadyExistsException extends BaseException {
	public AlreadyExistsException(String message) {
		super(message, HttpStatus.CONFLICT);
	}

}
