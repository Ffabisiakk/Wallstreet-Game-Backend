package pl.hollow.wallstreet.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.hollow.wallstreet.user.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    List<UserDto> usersToUserDtos(List<User> users);
}
