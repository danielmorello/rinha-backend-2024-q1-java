package br.com.dsm.RinhaBackend.domain.transaction.ports.outbound;

import br.com.dsm.RinhaBackend.domain.user.model.User;

public interface CreateTransactionPort {
  // TODO: Refazer os tipos e os nomes das funções para adaptar para as transações
  void createUser(User user);
}
