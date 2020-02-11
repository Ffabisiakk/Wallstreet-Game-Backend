package pl.hollow.wallstreet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserLeaderboardService {

    private Map<String, Double> scoresCache;

    private UserService userService;

    @Autowired
    public UserLeaderboardService(UserService userService) {
        this.userService = userService;
    }

    public Map<String, BigDecimal> generateLeaderboard() {
        Map<String, BigDecimal> scores = new HashMap<>();
        List<User> users = userService.getUsers();
        for (User user : users) {
            scores.put(user.getNickname(), generateScore());
        }
        return scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
    }

    private BigDecimal generateScore() {
        return null;
    }
}
