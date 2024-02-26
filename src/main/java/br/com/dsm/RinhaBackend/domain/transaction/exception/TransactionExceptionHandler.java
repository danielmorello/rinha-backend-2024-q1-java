package br.com.dsm.RinhaBackend.domain.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {

	@ExceptionHandler({ TransactionTypeNotFoundException.class })
	public ResponseEntity<Object> handleUserNotFoundException(TransactionTypeNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
	}

	@ExceptionHandler({ TransactionDescriptionLengthException.class })
	public ResponseEntity<Object> transactionDescriptionLengthException(
			TransactionDescriptionLengthException exception) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
	}

	@ExceptionHandler({ TransactionValueException.class })
	public ResponseEntity<Object> transactionValueException(
			TransactionValueException exception) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
	}
}
