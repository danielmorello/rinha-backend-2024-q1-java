package br.com.dsm.RinhaBackend.domain.user.mapper;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toUser(UserDto userDto) {
    User user = new User();
    user.setLimite(userDto.getLimite());
    user.setSaldo(userDto.getSaldo());

    return user;
  }

  public UserDto toUserDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setLimite(user.getLimite());
    userDto.setSaldo(user.getSaldo());

    return userDto;
  }
}
