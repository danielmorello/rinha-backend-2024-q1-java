package br.com.dsm.RinhaBackend.domain.user.ports.outbound;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import java.util.Optional;

public interface FindUserPort {
	Optional<User> findUser(Integer clientId);
}
