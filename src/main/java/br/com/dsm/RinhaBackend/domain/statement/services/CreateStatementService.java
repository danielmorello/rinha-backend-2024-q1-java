package br.com.dsm.RinhaBackend.domain.statement.services;

import br.com.dsm.RinhaBackend.domain.statement.dto.StatementDto;
import br.com.dsm.RinhaBackend.domain.statement.mapper.StatementMapper;
import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import br.com.dsm.RinhaBackend.domain.statement.ports.inbound.CreateStatementUseCase;
import br.com.dsm.RinhaBackend.domain.statement.ports.outbound.CreateStatementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStatementService implements CreateStatementUseCase {

	// TODO: verificar a adaptação para a classe de extrato

	@Autowired
	private StatementMapper statementMapper;

	@Autowired
	private CreateStatementPort createstatementPort;

	@Override
	public void createStatement(StatementDto statementDto) {
		Statement statement = statementMapper.toStatement(statementDto);
		createstatementPort.createStatement(statement);
	}
}
