package br.com.dsm.RinhaBackend.adapters.out.database.transaction;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.FindTransactionsPort;
import br.com.dsm.RinhaBackend.domain.transaction.repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindTransactionsAdapter implements FindTransactionsPort {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> findTransactions(Integer clientId) {
		List<Transaction> transactions = transactionRepository.findByClienteId(clientId);

		return transactions;
	}
}
