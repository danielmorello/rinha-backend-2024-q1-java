package br.com.dsm.RinhaBackend.domain.statement.services;

import br.com.dsm.RinhaBackend.domain.statement.model.Balance;
import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import br.com.dsm.RinhaBackend.domain.statement.ports.inbound.CreateStatementUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.FindTransactionsUseCase;
import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.FindUserUseCase;

import java.time.Instant;

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
		UserDto userDto = findUserUseCase.findUser(clietnId);
		Balance balance = new Balance();
		balance.setDataExtrato(Instant.now());
		balance.setLimite(userDto.getLimite());
		balance.setTotal(userDto.getSaldo());
		if (userDto.getTransacoes().size() > 10) {
			statement.setUltimasTransacoes(userDto.getTransacoes().subList(0, 10));
		} else {
			statement.setUltimasTransacoes(userDto.getTransacoes());
		}
		statement.setSaldo(balance);

		return statement;
	}

}
