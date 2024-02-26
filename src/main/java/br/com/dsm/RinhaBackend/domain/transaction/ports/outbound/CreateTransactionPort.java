package br.com.dsm.RinhaBackend.domain.transaction.ports.outbound;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;

public interface CreateTransactionPort {
	// TODO: Refazer os tipos e os nomes das funções para adaptar para as transações
	Transaction createTransaction(Transaction transaction);
}
