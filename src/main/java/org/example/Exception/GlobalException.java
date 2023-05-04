package org.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<String> handleDuplicateResource(DuplicateResourceException duplicateResourceException){
		return new ResponseEntity<>(duplicateResourceException.getMessage(),HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(NotFoundResourceException.class)
	public ResponseEntity<String> handleNotFoundResource(NotFoundResourceException notFoundResourceException){
		return new ResponseEntity<>(notFoundResourceException.getMessage(),HttpStatus.FORBIDDEN);
	}




}
