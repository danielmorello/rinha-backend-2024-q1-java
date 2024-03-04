package br.com.dsm.RinhaBackend.domain.user.mapper;

import br.com.dsm.RinhaBackend.domain.user.dto.UserDto;
import br.com.dsm.RinhaBackend.domain.user.model.User;

import java.util.ArrayList;
import java.util.List;

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

  public List<UserDto> toUserDtoList(List<User> userList) {
    List<UserDto> userDtoList = new ArrayList<>();
    for (User user : userList) {
      userDtoList.add(toUserDto(user));
    }

    return userDtoList;
  }
}
