package pl.hollow.wallstreet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.user.dto.UserDto;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
class UserController {

    private UserMapper userMapper;
    private UserFacade userFacade;

    @Autowired
    public UserController(UserMapper userMapper, UserFacade userFacade) {
        this.userMapper = userMapper;
        this.userFacade = userFacade;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userMapper.usersToUserDtos(userFacade.getUsers());
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return userMapper.userToUserDto(userFacade.getUser(username));
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userFacade.createUser(userMapper.userDtoToUser(userDto));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.userToUserDto(userFacade.updateUser(userMapper.userDtoToUser(userDto)));
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userFacade.deleteUser(username);
    }

}
