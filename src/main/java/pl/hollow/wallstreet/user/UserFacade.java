package pl.hollow.wallstreet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.hollow.wallstreet.exception.EntityNotFoundException;

import java.util.List;

@Component
public class UserFacade {

    private UserService userService;

    @Autowired
    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers() {
        return userService.getUsers();
    }

    public User getUser(String username) throws EntityNotFoundException {
        return userService.getUser(username);
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    public void deleteUser(String username) {
        userService.deleteUser(username);
    }
}
