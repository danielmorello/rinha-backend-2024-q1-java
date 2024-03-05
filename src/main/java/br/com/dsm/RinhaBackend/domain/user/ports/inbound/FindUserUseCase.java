package br.com.dsm.RinhaBackend.domain.user.ports.inbound;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import java.util.List;

public interface FindUserUseCase {
	UserDto findUser(Integer clientId);

	List<UserDto> findAllUser();
}
