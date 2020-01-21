package pl.hollow.wallstreet.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import pl.hollow.wallstreet.user.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    List<UserDto> usersToUserDtos(List<User> users);
}
