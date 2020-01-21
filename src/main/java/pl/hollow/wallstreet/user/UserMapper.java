package pl.hollow.wallstreet.user;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.hollow.wallstreet.user.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
//
//    @Mapping(source = "cash", numberFormat = "#.##E0", target = "cash")
//    @Mapping(source = "bitcoin", numberFormat = "#.##E0", target = "bitcoin")
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    List<UserDto> usersToUserDtos(List<User> users);
}
