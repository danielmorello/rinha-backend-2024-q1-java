package br.com.dsm.RinhaBackend.domain.transaction.services;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.FindTransactionsUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.FindTransactionsPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindTransactionsService implements FindTransactionsUseCase {

	@Autowired
	private FindTransactionsPort findTransactionsPort;

	@Override
	public List<Transaction> findTransactions(Integer clientId) {
		List<Transaction> transactions = findTransactionsPort.findTransactions(clientId);

		return transactions;
	}
}
