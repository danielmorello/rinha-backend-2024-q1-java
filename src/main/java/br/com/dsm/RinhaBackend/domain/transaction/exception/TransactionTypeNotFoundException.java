package br.com.dsm.RinhaBackend.domain.transaction.exception;

public class TransactionTypeNotFoundException extends RuntimeException {

	public TransactionTypeNotFoundException(String message) {
		super(message);
	}
}
