package br.com.dsm.RinhaBackend.domain.transaction.repository;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import jakarta.persistence.Id;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// TODO: Refazer os tipos e os nomes das funções para adaptar para as transações
public interface TransactionRepository extends JpaRepository<Transaction, Id> {
    ArrayList<Transaction> findByClienteId(Integer clientId);
}
