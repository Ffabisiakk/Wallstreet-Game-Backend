package pl.hollow.wallstreet.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.hollow.wallstreet.rate.RateService;

@SpringBootTest
class UserLeaderboardServiceTest {

    @Autowired
    private UserLeaderboardService service;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private RateService rateService;

    @Test
    public void shouldReturnEmptyMap() {
//        Given


//        When
        service.generateLeaderboard();
    }
}