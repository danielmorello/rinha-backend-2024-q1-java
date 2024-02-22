package br.com.dsm.RinhaBackend.database;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.CreateUserPort;
import br.com.dsm.RinhaBackend.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserAdapter implements CreateUserPort {

  @Autowired
  UserRepository userRepository;

  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }
}
