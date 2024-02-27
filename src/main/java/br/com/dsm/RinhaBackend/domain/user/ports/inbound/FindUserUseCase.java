package br.com.dsm.RinhaBackend.domain.user.ports.inbound;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import java.util.List;

public interface FindUserUseCase {
	UserDto findUser(Integer clientId);

	List<User> findAllUser();
}
