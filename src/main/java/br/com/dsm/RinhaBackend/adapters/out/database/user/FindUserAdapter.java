package br.com.dsm.RinhaBackend.adapters.out.database.user;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.FindUserPort;
import br.com.dsm.RinhaBackend.domain.user.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUserAdapter implements FindUserPort {

	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<User> findUser(Integer clientId) {
		return userRepository.findById(clientId);
	}
}
