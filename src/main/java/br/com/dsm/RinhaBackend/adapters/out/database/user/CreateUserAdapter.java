package br.com.dsm.RinhaBackend.adapters.out.database.user;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.CreateUserPort;
import br.com.dsm.RinhaBackend.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserAdapter implements CreateUserPort {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User userSaved = userRepository.save(user);

		return userSaved;
	}
}
