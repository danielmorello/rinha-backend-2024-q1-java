package br.com.dsm.RinhaBackend.domain.transaction.repository;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// TODO: Refazer os tipos e os nomes das funções para adaptar para as transações
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByClienteId(Integer clientId);
}
