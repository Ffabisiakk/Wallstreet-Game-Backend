package pl.hollow.wallstreet.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFetchUser() {
//        Given
        User user = new User();
        userRepository.save(user);
        String nickname = user.getNickname();

//        When
        Optional<User> fetchedUserOpt = userRepository.findById(nickname);

//        Then
        assertTrue(fetchedUserOpt.isPresent());
        assertEquals(nickname, fetchedUserOpt.get().getNickname());

//        CleanUp
        userRepository.deleteById(nickname);
    }
}