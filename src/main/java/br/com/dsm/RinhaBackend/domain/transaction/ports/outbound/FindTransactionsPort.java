package br.com.dsm.RinhaBackend.domain.transaction.ports.outbound;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import java.util.List;

public interface FindTransactionsPort {
	List<Transaction> findTransactions(Integer clientId);
}
