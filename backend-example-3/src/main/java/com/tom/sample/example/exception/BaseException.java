package com.tom.sample.example.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
@SuppressWarnings("serial")
public abstract class BaseException extends RuntimeException {

	private final HttpStatus status;

	public BaseException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

}
