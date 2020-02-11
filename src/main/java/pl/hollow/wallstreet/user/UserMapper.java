package pl.hollow.wallstreet.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.hollow.wallstreet.user.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface UserMapper {

    List<UserDto> usersToUserDtos(List<User> users);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
