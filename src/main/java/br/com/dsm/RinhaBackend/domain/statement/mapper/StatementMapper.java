package br.com.dsm.RinhaBackend.domain.statement.mapper;

import br.com.dsm.RinhaBackend.domain.statement.dto.StatementDto;
import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import org.springframework.stereotype.Component;

@Component
public class StatementMapper {

	// TODO: verificar a adaptação para a classe de extrato

	public Statement toStatement(StatementDto statementDto) {
		Statement statement = new Statement();
		statement.setValor(statementDto.getValor());
		statement.setTipo(statementDto.getTipo());
		statement.setDescricao(statementDto.getDescricao());

		return statement;
	}

	public StatementDto toStatementDto(Statement statement) {
		StatementDto statementDto = new StatementDto();
		statementDto.setValor(statement.getValor());
		statementDto.setTipo(statement.getTipo());
		statementDto.setDescricao(statement.getDescricao());

		return statementDto;
	}
}
