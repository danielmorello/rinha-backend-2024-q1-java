package br.com.dsm.RinhaBackend.database;

import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.CreateTransactionPort;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTransactionAdapter implements CreateTransactionPort {
  // TODO: Adaptar as classes para a transação
  @Autowired
  UserRepository userRepository;

  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }
}
