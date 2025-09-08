package com.tom.sample.example.exception;

import org.springframework.http.HttpStatus;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class DuplicateException extends CustomGlobalException {
	public DuplicateException(String message) {
		super(message, HttpStatus.CONFLICT);
	}
}
