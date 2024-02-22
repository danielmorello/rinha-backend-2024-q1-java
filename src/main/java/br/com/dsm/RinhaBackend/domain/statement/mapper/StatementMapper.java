package br.com.dsm.RinhaBackend.domain.statement.mapper;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class StatementMapper {
  // TODO: verificar a adaptação para a classe de extrato

  public Transaction toTransaction(TransactionDto transactionDto) {
    Transaction transaction = new Transaction();
    transaction.setValor(transactionDto.getValor());
    transaction.setTipo(transactionDto.getTipo());
    transaction.setDescricao(transactionDto.getDescricao());

    return transaction;
  }

  public TransactionDto toTransactionDto(Transaction transaction) {
    TransactionDto transactionDto = new TransactionDto();
    transactionDto.setValor(transaction.getValor());
    transactionDto.setTipo(transaction.getTipo());
    transactionDto.setDescricao(transaction.getDescricao());

    return transactionDto;
  }
}
