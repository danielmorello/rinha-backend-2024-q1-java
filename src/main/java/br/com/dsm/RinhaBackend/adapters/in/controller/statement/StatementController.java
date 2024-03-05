package br.com.dsm.RinhaBackend.adapters.in.controller.statement;

import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import br.com.dsm.RinhaBackend.domain.statement.ports.inbound.CreateStatementUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extrato")
public class StatementController {

	@Autowired
	private CreateStatementUseCase createStatementUseCase;

	@GetMapping("/{clientId}")
	public ResponseEntity<?> createStatement(@PathVariable("clientId") Integer clietnId) {
		Statement statement = createStatementUseCase.createStatement(clietnId);

		return ResponseEntity.ok().body(statement);
	}
}
