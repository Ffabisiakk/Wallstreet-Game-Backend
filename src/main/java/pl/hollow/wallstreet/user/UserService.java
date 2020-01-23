package pl.hollow.wallstreet.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.exception.EntityNotFoundException;

import java.util.List;

@Service
class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        LOGGER.info("Fetching list of all users.");
        return userRepository.findAll();
    }

    public User getUser(String username) throws EntityNotFoundException {
        LOGGER.info("Fetching user {}", username);
        return userRepository.findById(username).orElseThrow(() -> new EntityNotFoundException("Username: " + username));
    }

    public void createUser(User user) {
        LOGGER.info("Creating user {}", user.getNickname());
        userRepository.save(user);
    }

    public User updateUser(User user) {
        LOGGER.info("Updating user {}", user.getNickname());
        return userRepository.save(user);
    }

    public void deleteUser(String username) {
        LOGGER.info("Deleting user {}", username);
        userRepository.deleteById(username);
    }
}
