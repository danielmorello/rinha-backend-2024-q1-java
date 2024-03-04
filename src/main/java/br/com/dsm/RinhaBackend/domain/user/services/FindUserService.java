package br.com.dsm.RinhaBackend.domain.user.services;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.exception.UserNotFoundException;
import br.com.dsm.RinhaBackend.domain.user.mapper.UserMapper;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.FindUserUseCase;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.FindUserPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserService implements FindUserUseCase {

	@Autowired
	private FindUserPort findUserPort;

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto findUser(Integer clientId) {
		User user = findUserPort
				.findUser(clientId)
				.orElseThrow(() -> new UserNotFoundException("Cliente não encontrado com esse Id."));

		return userMapper.toUserDto(user);
	}

	@Override
	public List<UserDto> findAllUser() {
		List<User> userList = findUserPort.findAllUser();

		return userMapper.toUserDtoList(userList);
	}
}
