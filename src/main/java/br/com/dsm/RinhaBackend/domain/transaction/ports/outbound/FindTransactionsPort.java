package br.com.dsm.RinhaBackend.domain.transaction.ports.outbound;

import java.util.ArrayList;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;

public interface FindTransactionsPort {

    ArrayList<Transaction> findTransactions(Integer clientId);

}
