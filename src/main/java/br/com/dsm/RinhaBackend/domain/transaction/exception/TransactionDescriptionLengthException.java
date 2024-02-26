package br.com.dsm.RinhaBackend.domain.transaction.exception;

public class TransactionDescriptionLengthException extends RuntimeException {

	public TransactionDescriptionLengthException(String message) {
		super(message);
	}
}
