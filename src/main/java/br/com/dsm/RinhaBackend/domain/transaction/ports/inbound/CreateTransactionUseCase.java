package br.com.dsm.RinhaBackend.domain.transaction.ports.inbound;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;

public interface CreateTransactionUseCase {
	// TODO: Refazer os tipos e os nomes das funções para adaptar para as transações
	UserDto createTransaction(Integer clientId, TransactionDto transactionDto);
}
