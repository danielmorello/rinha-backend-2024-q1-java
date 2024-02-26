package br.com.dsm.RinhaBackend.adapters.in.controller.user;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.CreateUserUseCase;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.FindUserUseCase;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping
	public void createUser(@RequestBody UserDto userDto) {
		createUserUseCase.createUser(userDto);
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<UserDto> findUser(@PathVariable("clientId") Integer clientId) {
		UserDto userDto = findUserUseCase.findUser(clientId);
		return ResponseEntity.ok(userDto);
	}

	@PostMapping("/{clientId}")
	public ResponseEntity<UserDto> updateUser(
		@PathVariable("clientId") Integer clientId,
		@RequestBody UserDto userDto
	) {
		UserDto userDtoCreated = updateUserUseCase.updateUser(clientId, userDto);

		return ResponseEntity.ok(userDtoCreated);
	}
}
