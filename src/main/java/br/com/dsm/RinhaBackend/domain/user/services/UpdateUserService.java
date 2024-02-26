package br.com.dsm.RinhaBackend.domain.user.services;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.exception.UserNotFoundException;
import br.com.dsm.RinhaBackend.domain.user.mapper.UserMapper;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import br.com.dsm.RinhaBackend.domain.user.ports.inbound.UpdateUserUseCase;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.FindUserPort;
import br.com.dsm.RinhaBackend.domain.user.ports.outbound.UpdateUserPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateUserService implements UpdateUserUseCase {

	@Autowired
	private UpdateUserPort updateUserPort;

	@Autowired
	private FindUserPort findUserPort;

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto updateUser(Integer clientId, UserDto userDto) {
		User oldUser = findUserPort
			.findUser(clientId)
			.orElseThrow(() -> new UserNotFoundException("Cliente não encontrado com esse Id."));
		User user = userMapper.toUser(userDto);
		User userUpdated = updateUserPort.updateUser(oldUser, user);

		return userMapper.toUserDto(userUpdated);
	}
}
