package br.com.dsm.RinhaBackend.domain.statement.ports.outbound;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;

public interface CreateStatementPort {
  // TODO: verificar a adaptação para a classe de extrato
  void createTransaction(Transaction transaction);
}
