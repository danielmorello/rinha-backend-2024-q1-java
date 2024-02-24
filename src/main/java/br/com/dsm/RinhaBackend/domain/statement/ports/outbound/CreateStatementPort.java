package br.com.dsm.RinhaBackend.domain.statement.ports.outbound;

import br.com.dsm.RinhaBackend.domain.statement.model.Statement;

public interface CreateStatementPort {
	// TODO: verificar a adaptação para a classe de extrato
	void createStatement(Statement statement);
}
