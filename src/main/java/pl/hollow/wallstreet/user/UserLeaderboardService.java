package pl.hollow.wallstreet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.rate.RateService;
import pl.hollow.wallstreet.util.MapUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLeaderboardService {

    private Map<String, BigDecimal> leaderboard;

    private UserService userService;
    private RateService rateService;

    @Autowired
    public UserLeaderboardService(UserService userService, RateService rateService) {
        this.userService = userService;
        this.rateService = rateService;
    }

    public Map<String, BigDecimal> generateLeaderboard() {
        Map<String, BigDecimal> scores = new HashMap<>();
        List<User> users = userService.getUsers();
        Map<String, BigDecimal> recentRates = rateService.getRecentRates();
        for (User user : users) {
            scores.put(user.getNickname(), generateScore(user, recentRates));
        }
        return MapUtil.sortByValueDesc(scores);
    }

    public Map<String, BigDecimal> getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard() {
        this.leaderboard = generateLeaderboard();
    }

    private BigDecimal generateScore(User user, Map<String, BigDecimal> rates) {
        Map<String, BigDecimal> wallet = user.getWallet();
        return wallet.get("PLN").setScale(5)
                .add(wallet.get("BTC").setScale(5).divide(rates.get("BTC"), RoundingMode.HALF_DOWN))
                .add(wallet.get("BGN").setScale(5).divide(rates.get("BGN"), RoundingMode.HALF_DOWN))
                .add(wallet.get("CHF").setScale(5).divide(rates.get("CHF"), RoundingMode.HALF_DOWN))
                .add(wallet.get("CZK").setScale(5).divide(rates.get("CZK"), RoundingMode.HALF_DOWN))
                .add(wallet.get("EUR").setScale(5).divide(rates.get("EUR"), RoundingMode.HALF_DOWN))
                .add(wallet.get("GBP").setScale(5).divide(rates.get("GBP"), RoundingMode.HALF_DOWN))
                .add(wallet.get("HUF").setScale(5).divide(rates.get("HUF"), RoundingMode.HALF_DOWN))
                .add(wallet.get("NOK").setScale(5).divide(rates.get("NOK"), RoundingMode.HALF_DOWN))
                .add(wallet.get("RON").setScale(5).divide(rates.get("RON"), RoundingMode.HALF_DOWN))
                .add(wallet.get("RUB").setScale(5).divide(rates.get("RUB"), RoundingMode.HALF_DOWN))
                .add(wallet.get("SEK").setScale(5).divide(rates.get("SEK"), RoundingMode.HALF_DOWN))
                .add(wallet.get("USD").setScale(5).divide(rates.get("USD"), RoundingMode.HALF_DOWN));
    }
}
