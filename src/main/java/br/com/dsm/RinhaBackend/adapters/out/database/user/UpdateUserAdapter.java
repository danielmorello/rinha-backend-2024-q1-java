package br.com.dsm.RinhaBackend.adapters.out.database.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.UpdateUserPort;
import br.com.dsm.RinhaBackend.domain.user.repository.UserRepository;

@Component
public class UpdateUserAdapter implements UpdateUserPort {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
