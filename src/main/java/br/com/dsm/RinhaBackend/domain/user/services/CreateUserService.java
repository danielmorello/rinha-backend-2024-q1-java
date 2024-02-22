package br.com.dsm.RinhaBackend.domain.user.services;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.mapper.UserMapper;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.CreateUserUseCase;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.CreateUserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUserUseCase {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private CreateUserPort createUserPort;

  @Override
  public void createUser(UserDto userDto) {
    User user = userMapper.toUser(userDto);
    createUserPort.createUser(user);
  }
}
