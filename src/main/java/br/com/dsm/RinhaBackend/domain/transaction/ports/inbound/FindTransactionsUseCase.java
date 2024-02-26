package br.com.dsm.RinhaBackend.domain.transaction.ports.inbound;

import java.util.ArrayList;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;

public interface FindTransactionsUseCase {

    ArrayList<Transaction> findTransactions(Integer clientId);

}
