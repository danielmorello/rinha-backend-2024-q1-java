package br.com.dsm.RinhaBackend.domain.statement.ports.inbound;

import br.com.dsm.RinhaBackend.domain.statement.model.Statement;

public interface CreateStatementUseCase {
	Statement createStatement(Integer clietnId);
}
