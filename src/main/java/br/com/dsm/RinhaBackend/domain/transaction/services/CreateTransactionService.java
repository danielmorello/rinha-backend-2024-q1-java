package br.com.dsm.RinhaBackend.domain.transaction.services;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.exception.TransactionTypeNotFoundException;
import br.com.dsm.RinhaBackend.domain.transaction.mapper.TransactionMapper;
import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.outbound.CreateTransactionPort;
import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.exception.UserNotFoundException;
import br.com.dsm.RinhaBackend.domain.user.mapper.UserMapper;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.FindUserPort;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.UpdateUserPort;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService implements CreateTransactionUseCase {

	@Autowired
	private TransactionMapper transactionMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CreateTransactionPort createTransactionPort;

	@Autowired
	private FindUserPort findUserPort;

	@Autowired
	private UpdateUserPort updateUserPort;

	@Override
	public UserDto createTransaction(Integer clientId, TransactionDto transactionDto) {
		if (transactionDto.getTipo().equals("d") || transactionDto.getTipo().equals("c")) {
			Transaction transaction = transactionMapper.toTransaction(transactionDto);
			User user = findUserPort
					.findUser(clientId)
					.orElseThrow(() -> new UserNotFoundException("Cliente não encontrado com esse Id."));
			transaction.setCliente(user);
			transaction.setRealizada_em(Instant.now());
			Transaction transactionCreated = createTransactionPort.createTransaction(transaction);
			user.updateBalance(transactionCreated.getValor(), transactionCreated.getTipo());
			updateUserPort.updateUser(user);

			return userMapper.toUserDto(user);
		} else {
			throw new TransactionTypeNotFoundException("Tipo de transação não encontrado");
		}
	}
}
