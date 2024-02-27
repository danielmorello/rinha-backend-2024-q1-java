package br.com.dsm.RinhaBackend.domain.transaction.ports.inbound;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import java.util.List;

public interface FindTransactionsUseCase {
	List<Transaction> findTransactions(Integer clientId);
}
