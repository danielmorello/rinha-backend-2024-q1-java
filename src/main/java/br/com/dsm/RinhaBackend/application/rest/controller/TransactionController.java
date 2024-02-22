package br.com.dsm.RinhaBackend.application.rest.controller;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
  // TODO: adaptar as classes para as trasnsações

  @Autowired
  private CreateUserUseCase createUserUseCase;

  @PostMapping
  public void createUser(@RequestBody UserDto userDto) {
    createUserUseCase.createUser(userDto);
  }
}
