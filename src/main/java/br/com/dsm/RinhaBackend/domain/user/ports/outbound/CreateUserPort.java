package br.com.dsm.RinhaBackend.domain.user.ports.outbound;

import br.com.dsm.RinhaBackend.domain.user.model.User;

public interface CreateUserPort {
  void createUser(User user);
}
