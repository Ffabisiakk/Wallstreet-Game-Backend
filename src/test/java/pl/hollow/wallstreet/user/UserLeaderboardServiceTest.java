package pl.hollow.wallstreet.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.hollow.wallstreet.rate.RateCaches;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserLeaderboardServiceTest {

    @Autowired
    private UserLeaderboardService service;

    @MockBean
    private UserService userService;
    @MockBean
    private RateCaches rateCaches;

    @Test
    public void shouldReturnLeaderboardWithInitialUserWallet() {
//        Given
        List<User> users = new ArrayList<>();
        users.add(new User("test_nick", "test_mail"));
        Map<String, BigDecimal> rates = new HashMap<>();
        String[] currency = {"BTC", "BGN", "CHF", "CZK", "EUR", "GBP", "HUF", "NOK", "RON", "RUB", "SEK", "USD"};
        int i = 1;
        for (String cur : currency) {
            rates.put(cur, new BigDecimal(i++));
        }

        when(userService.getUsers()).thenReturn(users);
        when(rateCaches.getRateCache()).thenReturn(rates);

//        When
        Map<String, BigDecimal> result = service.generateLeaderboard();
        Map.Entry<String, BigDecimal> firstEntry = result.entrySet().iterator().next();

//        Then
        assertEquals(1, result.size());
        assertEquals("test_nick", firstEntry.getKey());
        assertEquals(BigDecimal.valueOf(1000), firstEntry.getValue());
    }

    @Test
    public void shouldReturnLeaderboardWithModifiedBitcoinUserWallet() {
//        Given
        List<User> users = new ArrayList<>();
        User user = new User("test_nick", "test_mail");
        user.getWallet().put("BTC", BigDecimal.valueOf(1));
        users.add(user);
        Map<String, BigDecimal> rates = new HashMap<>();
        String[] currency = {"BTC", "BGN", "CHF", "CZK", "EUR", "GBP", "HUF", "NOK", "RON", "RUB", "SEK", "USD"};
        int i = 1;
        for (String cur : currency) {
            rates.put(cur, new BigDecimal(i++));
        }

        when(userService.getUsers()).thenReturn(users);
        when(rateCaches.getRateCache()).thenReturn(rates);

//        When
        Map<String, BigDecimal> result = service.generateLeaderboard();
        Map.Entry<String, BigDecimal> firstEntry = result.entrySet().iterator().next();

//        Then
        assertEquals(1, result.size());
        assertEquals("test_nick", firstEntry.getKey());
        assertEquals(BigDecimal.valueOf(1001), firstEntry.getValue());
    }

    @Test
    public void shouldReturnLeaderboardWithModifiedBitcoinAndEuroUserWallet() {
//        Given
        List<User> users = new ArrayList<>();
        User user = new User("test_nick", "test_mail");
        user.getWallet().put("BTC", BigDecimal.valueOf(1));
        user.getWallet().put("EUR", BigDecimal.valueOf(5));
        users.add(user);
        Map<String, BigDecimal> rates = new HashMap<>();
        String[] currency = {"BTC", "BGN", "CHF", "CZK", "EUR", "GBP", "HUF", "NOK", "RON", "RUB", "SEK", "USD"};
        int i = 1;
        for (String cur : currency) {
            rates.put(cur, new BigDecimal(i++));
        }

        when(userService.getUsers()).thenReturn(users);
        when(rateCaches.getRateCache()).thenReturn(rates);

//        When
        Map<String, BigDecimal> result = service.generateLeaderboard();
        Map.Entry<String, BigDecimal> firstEntry = result.entrySet().iterator().next();

//        Then
        assertEquals(1, result.size());
        assertEquals("test_nick", firstEntry.getKey());
        assertEquals(BigDecimal.valueOf(1026), firstEntry.getValue());
    }

    @Test
    public void shouldReturnLeaderboardWithThreeUsersModifiedBitcoinAndEuroUserWallet() {
//        Given
        List<User> users = new ArrayList<>();
        User user = new User("test_nick", "test_mail");
        user.getWallet().put("BTC", BigDecimal.valueOf(1));
        users.add(user);
        User user2 = new User("test_nick2", "test_mail2");
        user2.getWallet().put("BTC", BigDecimal.valueOf(5));
        users.add(user2);
        User user3 = new User("test_nick3", "test_mail3");
        user3.getWallet().put("BTC", BigDecimal.valueOf(3));
        users.add(user3);

        Map<String, BigDecimal> rates = new HashMap<>();
        String[] currency = {"BTC", "BGN", "CHF", "CZK", "EUR", "GBP", "HUF", "NOK", "RON", "RUB", "SEK", "USD"};
        int i = 1;
        for (String cur : currency) {
            rates.put(cur, new BigDecimal(i++));
        }

        when(userService.getUsers()).thenReturn(users);
        when(rateCaches.getRateCache()).thenReturn(rates);

//        When
        Map<String, BigDecimal> result = service.generateLeaderboard();
        Iterator<Map.Entry<String, BigDecimal>> iterator = result.entrySet().iterator();

//        Then
        assertEquals(3, result.size());
        Map.Entry<String, BigDecimal> firstEntry = iterator.next();
        assertEquals("test_nick2", firstEntry.getKey());
        assertEquals(BigDecimal.valueOf(1005), firstEntry.getValue());
        Map.Entry<String, BigDecimal> secondEntry = iterator.next();
        assertEquals("test_nick3", secondEntry.getKey());
        assertEquals(BigDecimal.valueOf(1003), secondEntry.getValue());
        Map.Entry<String, BigDecimal> thirdEntry = iterator.next();
        assertEquals("test_nick", thirdEntry.getKey());
        assertEquals(BigDecimal.valueOf(1001), thirdEntry.getValue());
    }
}