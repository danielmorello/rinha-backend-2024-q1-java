package br.com.dsm.RinhaBackend.database;

import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import br.com.dsm.RinhaBackend.domain.statement.ports.outbound.CreateStatementPort;
import br.com.dsm.RinhaBackend.domain.statement.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateStatementAdapter implements CreateStatementPort {

	// TODO: Adaptar as classes para a transação
	@Autowired
	StatementRepository statementRepository;

	@Override
	public void createStatement(Statement statement) {
		statementRepository.save(statement);
	}
}
