package br.com.dsm.RinhaBackend.domain.transaction.ports.inbound;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;

public interface CreateTransactionUseCase {
	// TODO: Refazer os tipos e os nomes das funções para adaptar para as transações
	void createTransaction(Integer clientId, TransactionDto transactionDto);
}
