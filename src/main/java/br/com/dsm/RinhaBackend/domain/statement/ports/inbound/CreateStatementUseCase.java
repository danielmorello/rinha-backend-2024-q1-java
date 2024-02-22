package br.com.dsm.RinhaBackend.domain.statement.ports.inbound;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;

public interface CreateStatementUseCase {
  // TODO: verificar a adaptação para a classe de extrato
  void createTransaction(TransactionDto transactionDto);
}
