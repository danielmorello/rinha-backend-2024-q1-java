package br.com.dsm.RinhaBackend.database;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.CreateTransactionPort;
import br.com.dsm.RinhaBackend.domain.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTransactionAdapter implements CreateTransactionPort {

	// TODO: Adaptar as classes para a transação
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public void createTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}
}
