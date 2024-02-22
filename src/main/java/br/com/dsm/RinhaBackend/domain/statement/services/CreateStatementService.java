package br.com.dsm.RinhaBackend.domain.statement.services;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.mapper.TransactionMapper;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.CreateTransactionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStatementService implements CreateTransactionUseCase {
  // TODO: verificar a adaptação para a classe de extrato

  @Autowired
  private TransactionMapper transactionMapper;

  @Autowired
  private CreateTransactionPort createtransactionPort;

  @Override
  public void createTransaction(TransactionDto transactionDto) {
    Transaction transaction = transactionMapper.toTransaction(transactionDto);
    createtransactionPort.createTransaction(transaction);
  }
}
