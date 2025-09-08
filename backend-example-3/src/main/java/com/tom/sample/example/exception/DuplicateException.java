package com.tom.sample.example.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class DuplicateException extends BaseException {
	public DuplicateException(String message) {
		super(message, HttpStatus.CONFLICT);
	}
}
