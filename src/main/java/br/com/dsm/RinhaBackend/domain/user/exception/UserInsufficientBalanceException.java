package br.com.dsm.RinhaBackend.domain.user.exception;

public class UserInsufficientBalanceException extends RuntimeException {

	public UserInsufficientBalanceException(String message) {
		super(message);
	}
}
