package br.com.dsm.RinhaBackend.adapters.in.rest.controller;

import br.com.dsm.RinhaBackend.domain.statement.dto.StatementDto;
import br.com.dsm.RinhaBackend.domain.statement.ports.inbound.CreateStatementUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extrato")
public class StatementController {

	@Autowired
	private CreateStatementUseCase createStatementUseCase;

	@PostMapping
	public void createStatement(@RequestBody StatementDto statementDto) {
		createStatementUseCase.createStatement(statementDto);
	}
}
