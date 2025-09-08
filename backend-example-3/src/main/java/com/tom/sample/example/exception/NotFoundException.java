package com.tom.sample.example.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class NotFoundException extends BaseException {
	public NotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}
}
