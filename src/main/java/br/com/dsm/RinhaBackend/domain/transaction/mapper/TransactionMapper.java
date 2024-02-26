package br.com.dsm.RinhaBackend.domain.transaction.mapper;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.exception.TransactionDescriptionLengthException;
import br.com.dsm.RinhaBackend.domain.transaction.exception.TransactionValueException;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

  public Transaction toTransaction(TransactionDto transactionDto) {
    Transaction transaction = new Transaction();
    if (transactionDto.getValor() > 0) {
      transaction.setValor(transactionDto.getValor());
    } else {
      throw new TransactionValueException("O valor da transação deve ser um inteiro positivo.");
    }
    transaction.setTipo(transactionDto.getTipo());
    if (transactionDto.getDescricao().length() <= 10 && transactionDto.getDescricao().length() >= 1) {
      transaction.setDescricao(transactionDto.getDescricao());
    } else {
      throw new TransactionDescriptionLengthException("O tamanho da ddescrição não esta compatível");
    }

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
