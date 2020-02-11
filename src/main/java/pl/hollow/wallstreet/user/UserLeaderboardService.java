package pl.hollow.wallstreet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.rate.RateCaches;
import pl.hollow.wallstreet.util.MapUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLeaderboardService {

    private Map<String, Double> scoresCache;

    private UserService userService;
    private RateCaches rateCaches;

    @Autowired
    public UserLeaderboardService(UserService userService, RateCaches rateCaches) {
        this.userService = userService;
        this.rateCaches = rateCaches;
    }

    public Map<String, BigDecimal> generateLeaderboard() {
        Map<String, BigDecimal> scores = new HashMap<>();
        List<User> users = userService.getUsers();
        Map<String, BigDecimal> recentRates = rateCaches.getRateCache();
        for (User user : users) {
            scores.put(user.getNickname(), generateScore(user, recentRates));
        }
        return MapUtil.sortByValueDesc(scores);
    }

    private BigDecimal generateScore(User user, Map<String, BigDecimal> rates) {
        Map<String, BigDecimal> wallet = user.getWallet();
        return wallet.get("PLN")
                .add(wallet.get("BTC").multiply(rates.get("BTC")))
                .add(wallet.get("BGN").multiply(rates.get("BGN")))
                .add(wallet.get("CHF").multiply(rates.get("CHF")))
                .add(wallet.get("CZK").multiply(rates.get("CZK")))
                .add(wallet.get("EUR").multiply(rates.get("EUR")))
                .add(wallet.get("GBP").multiply(rates.get("GBP")))
                .add(wallet.get("HUF").multiply(rates.get("HUF")))
                .add(wallet.get("NOK").multiply(rates.get("NOK")))
                .add(wallet.get("RON").multiply(rates.get("RON")))
                .add(wallet.get("RUB").multiply(rates.get("RUB")))
                .add(wallet.get("SEK").multiply(rates.get("SEK")))
                .add(wallet.get("USD").multiply(rates.get("USD")));
    }
}
