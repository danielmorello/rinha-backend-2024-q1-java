package br.com.dsm.RinhaBackend.domain.user.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}
}
