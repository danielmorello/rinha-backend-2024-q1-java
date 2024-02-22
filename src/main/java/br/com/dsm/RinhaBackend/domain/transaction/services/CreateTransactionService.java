package br.com.dsm.RinhaBackend.domain.transaction.services;

import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.mapper.UserMapper;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.CreateUserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService implements CreateTransactionUseCase {
  // TODO: Refazer os tipos e os nomes das funções para adaptar para as transações

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
