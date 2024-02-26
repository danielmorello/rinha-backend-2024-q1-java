package br.com.dsm.RinhaBackend.adapters.out.database.transaction;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.FindTransactionsPort;
import br.com.dsm.RinhaBackend.domain.transaction.repository.TransactionRepository;

@Component
public class FindTransactionsAdapter implements FindTransactionsPort {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public ArrayList<Transaction> findTransactions(Integer clientId) {
        ArrayList<Transaction> transactions = transactionRepository.findByClienteId(clientId);

        return transactions;

    }

}
