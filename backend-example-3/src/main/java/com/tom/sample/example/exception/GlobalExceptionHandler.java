package com.tom.sample.example.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiErrorResponse> handleApiExceptions(BaseException ex) {
        var errorResponse = new ApiErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

	/*
	 * Ele vai dar um override no controle de excessão do spring boot. Quando
	 * ocorrer uma excessão em vez de retornar uma linha de argumento grande ele vai
	 * retornar um código pequeno.
	 */
    
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exp) {

		Map<String, String> errors = exp.getBindingResult().getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
	}

}
