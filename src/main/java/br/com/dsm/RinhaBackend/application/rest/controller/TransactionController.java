package br.com.dsm.RinhaBackend.application.rest.controller;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

	@Autowired
	private CreateTransactionUseCase createTransactionUseCase;

	@PostMapping("/{clientId}")
	public void createTransaction(
		@PathVariable("clientId") Integer clientId,
		@RequestBody TransactionDto transactionDto
	) {
		createTransactionUseCase.createTransaction(clientId, transactionDto);
	}
}
