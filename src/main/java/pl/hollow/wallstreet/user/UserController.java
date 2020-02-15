package pl.hollow.wallstreet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.user.dto.UserDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
class UserController {

    private UserMapper userMapper;
    private UserService userService;
    private UserLeaderboardService userLeaderboardService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService, UserLeaderboardService userLeaderboardService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.userLeaderboardService = userLeaderboardService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userMapper.usersToUserDtos(userService.getUsers());
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return userMapper.userToUserDto(userService.getUser(username));
    }

    @GetMapping("/leaderboard")
    public Map<String, BigDecimal> getLeaderboard() {
        return userLeaderboardService.getLeaderboard();
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
