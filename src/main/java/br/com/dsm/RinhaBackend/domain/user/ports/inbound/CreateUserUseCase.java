package br.com.dsm.RinhaBackend.domain.user.ports.inbound;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;

public interface CreateUserUseCase {
  void createUser(UserDto userDto);
}
