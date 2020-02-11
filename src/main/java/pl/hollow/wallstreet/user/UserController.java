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
    private UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userMapper.usersToUserDtos(userService.getUsers());
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return userMapper.userToUserDto(userService.getUser(username));
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userMapper.userDtoToUser(userDto));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.userToUserDto(userService.updateUser(userMapper.userDtoToUser(userDto)));
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

}
