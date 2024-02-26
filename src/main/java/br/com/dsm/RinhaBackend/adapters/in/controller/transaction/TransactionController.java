package br.com.dsm.RinhaBackend.adapters.in.controller.transaction;

import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<UserDto> createTransaction(
		@PathVariable("clientId") Integer clientId,
		@RequestBody TransactionDto transactionDto
	) {
		UserDto transactionDtoCreated = createTransactionUseCase.createTransaction(clientId, transactionDto);

		return ResponseEntity.ok(transactionDtoCreated);
	}
}
