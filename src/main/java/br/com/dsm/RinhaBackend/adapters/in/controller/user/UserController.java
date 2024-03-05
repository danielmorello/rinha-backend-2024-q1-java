package br.com.dsm.RinhaBackend.adapters.in.controller.user;

import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import br.com.dsm.RinhaBackend.domain.statement.ports.inbound.CreateStatementUseCase;
import br.com.dsm.RinhaBackend.domain.transaction.dto.TransactionDto;
import br.com.dsm.RinhaBackend.domain.transaction.ports.inbound.CreateTransactionUseCase;
import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.CreateUserUseCase;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.FindUserUseCase;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.UpdateUserUseCase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class UserController {

	@Autowired
	private CreateUserUseCase createUserUseCase;

	@Autowired
	private FindUserUseCase findUserUseCase;

	@Autowired
	private UpdateUserUseCase updateUserUseCase;

	@Autowired
	private CreateTransactionUseCase createTransactionUseCase;

	@Autowired
	private CreateStatementUseCase createStatementUseCase;

	// +++++++++++++++++++++++++++++++++++++++++CREATE+++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
		UserDto userDtoSaved = createUserUseCase.createUser(userDto);

		return ResponseEntity.ok().body(userDtoSaved);
	}

	@PostMapping("/{clientId}/transacoes")
	public UserDto createTransaction(
			@PathVariable("clientId") Integer clientId,
			@RequestBody TransactionDto transactionDto) {

		return createTransactionUseCase.createTransaction(clientId, transactionDto);
	}

	// +++++++++++++++++++++++++++++++++++++++++READ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GetMapping("/{clientId}")
	public ResponseEntity<UserDto> findUser(@PathVariable("clientId") Integer clientId) {
		UserDto userDto = findUserUseCase.findUser(clientId);

		return ResponseEntity.ok(userDto);
	}

	@GetMapping("/{clientId}/extrato")
	public ResponseEntity<?> findStatement(@PathVariable("clientId") Integer clientId) {
		Statement statement = createStatementUseCase.createStatement(clientId);

		return ResponseEntity.ok().body(statement);
	}

	@GetMapping
	public ResponseEntity<?> findAllUser() {
		// Corrigir o retorno do tipo user para userdto
		List<UserDto> userList = findUserUseCase.findAllUser();

		return ResponseEntity.ok().body(userList);
	}

	// +++++++++++++++++++++++++++++++++++++++++UPDATE+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@PutMapping("/{clientId}")
	public ResponseEntity<UserDto> updateUser(
			@PathVariable("clientId") Integer clientId,
			@RequestBody UserDto userDto) {
		UserDto userDtoCreated = updateUserUseCase.updateUser(clientId, userDto);

		return ResponseEntity.ok(userDtoCreated);
	}
}
