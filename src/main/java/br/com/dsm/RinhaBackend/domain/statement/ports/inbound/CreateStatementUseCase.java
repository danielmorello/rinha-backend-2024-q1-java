package br.com.dsm.RinhaBackend.domain.statement.ports.inbound;

import br.com.dsm.RinhaBackend.domain.statement.dto.StatementDto;

public interface CreateStatementUseCase {
	// TODO: verificar a adaptação para a classe de extrato
	void createStatement(StatementDto statementDto);
}
