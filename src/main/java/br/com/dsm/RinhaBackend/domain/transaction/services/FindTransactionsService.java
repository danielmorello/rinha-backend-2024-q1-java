package br.com.dsm.RinhaBackend.domain.transaction.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.FindTransactionsUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.FindTransactionsPort;

@Service
public class FindTransactionsService implements FindTransactionsUseCase {
    @Autowired
    private FindTransactionsPort findTransactionsPort;

    @Override
    public ArrayList<Transaction> findTransactions(Integer clientId) {
        ArrayList<Transaction> transactions = findTransactionsPort.findTransactions(clientId);

        return transactions;
    }

}
