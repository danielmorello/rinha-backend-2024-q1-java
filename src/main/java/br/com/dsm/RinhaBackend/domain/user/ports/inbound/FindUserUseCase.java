package br.com.dsm.RinhaBackend.domain.user.ports.inbound;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;

public interface FindUserUseCase {
	UserDto findUser(Integer clientId);
}
