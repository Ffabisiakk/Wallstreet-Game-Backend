package pl.hollow.wallstreet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.client.BlockchainInfoClient;
import pl.hollow.wallstreet.user.dto.UserDto;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {

    private UserFacade userFacade;

    @Autowired
    BlockchainInfoClient client;

    @Autowired
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return UserMapper.INSTANCE.usersToUserDtos(userFacade.getUsers());
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable String username) {
        return UserMapper.INSTANCE.userToUserDto(userFacade.getUser(username));
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userFacade.createUser(UserMapper.INSTANCE.userDtoToUser(userDto));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return UserMapper.INSTANCE.userToUserDto(userFacade.updateUser(UserMapper.INSTANCE.userDtoToUser(userDto)));
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userFacade.deleteUser(username);
    }

    @GetMapping("/test")
    public BigDecimal getRates() {
        System.out.println(client.getBitcoinCurrencyRate("PLN", "1000000").toString());
        return client.getBitcoinCurrencyRate("PLN", "1000000");
    }
}
