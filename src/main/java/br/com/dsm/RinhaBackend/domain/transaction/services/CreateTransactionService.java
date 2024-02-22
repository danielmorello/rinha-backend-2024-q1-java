package br.com.dsm.RinhaBackend.domain.transaction.services;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.mapper.TransactionMapper;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.CreateTransactionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService implements CreateTransactionUseCase {
  // TODO: Refazer os tipos e os nomes das funções para adaptar para as transações

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
