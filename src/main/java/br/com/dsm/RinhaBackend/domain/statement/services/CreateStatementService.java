package br.com.dsm.RinhaBackend.domain.statement.services;

import br.com.dsm.RinhaBackend.domain.statement.model.Balance;
import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import br.com.dsm.RinhaBackend.domain.statement.ports.inbound.CreateStatementUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.FindTransactionsUseCase;
import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.FindUserUseCase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStatementService implements CreateStatementUseCase {
	@Autowired
	FindUserUseCase findUserUseCase;

	@Autowired
	FindTransactionsUseCase findTransactionsUseCase;

	@Override
	public Statement createStatement(Integer clietnId) {
		Statement statement = new Statement();
		// Buscar saldo e limite do cliente
		UserDto userDto = findUserUseCase.findUser(clietnId);
		Balance balance = new Balance();
		balance.setDataExtrato(LocalDateTime.now());
		balance.setLimite(userDto.getLimite());
		balance.setTotal(userDto.getSaldo());
		// Buscar as 10 ultimass transacoes do cliente
		statement.setUltimasTransacoes(userDto.getTransacoes());
		statement.setSaldo(balance);

		return statement;
	}

}
