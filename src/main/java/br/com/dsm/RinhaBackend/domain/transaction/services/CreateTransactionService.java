package br.com.dsm.RinhaBackend.domain.transaction.services;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.mapper.TransactionMapper;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.CreateTransactionPort;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.FindUserPort;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService implements CreateTransactionUseCase {

	// TODO: Refazer os tipos e os nomes das funções para adaptar para as transações

	@Autowired
	private TransactionMapper transactionMapper;

	@Autowired
	private CreateTransactionPort createTransactionPort;

	@Autowired
	private FindUserPort findUserPort;

	@Override
	public void createTransaction(Integer clientId, TransactionDto transactionDto) {
		// TODO: verificar se as transacoes sao do tipo e somente do tipo 'd' ou 'c'
		// TODO: verificar a necessidades das exceptions para os tipos de dados na entrada
		Transaction transaction = transactionMapper.toTransaction(transactionDto);
		User user = findUserPort.findUser(clientId).orElseThrow();
		transaction.setCliente(user);
		transaction.setRealizada_em(LocalDateTime.now());
		createTransactionPort.createTransaction(transaction);
	}
}
