package com.tom.sample.example.exception;

import org.springframework.http.HttpStatus;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class AlreadyExistsException extends CustomGlobalException {
	public AlreadyExistsException(String message) {
		super(message, HttpStatus.CONFLICT);
	}
}
