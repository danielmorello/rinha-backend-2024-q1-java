package br.com.dsm.RinhaBackend.domain.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {

	@ExceptionHandler({ TransactionTypeNotFoundException.class })
	public ResponseEntity<Object> handleUserNotFoundException(TransactionTypeNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
