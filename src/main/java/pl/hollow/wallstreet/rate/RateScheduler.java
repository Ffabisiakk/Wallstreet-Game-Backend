package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.hollow.wallstreet.exception.InvalidRatesException;
import pl.hollow.wallstreet.user.UserLeaderboardService;
import pl.hollow.wallstreet.util.StringUtil;

import java.time.LocalDateTime;

@Component
public class RateScheduler {

    private RateService rateService;
    private RateProvider rateProvider;
    private UserLeaderboardService userLeaderboardService;

    @Autowired
    public RateScheduler(RateService rateService, RateProvider rateProvider, UserLeaderboardService userLeaderboardService) {
        this.rateService = rateService;
        this.rateProvider = rateProvider;
        this.userLeaderboardService = userLeaderboardService;
    }

    @Scheduled(cron = "0 0 * ? * *")
//    @Scheduled(fixedDelay = 10 * 1000)
    public void updateRates() {
        try {
            Rate rate = rateProvider.generateRecentRate();
            rateService.createRate(rate);
            userLeaderboardService.setLeaderboard();
        } catch (InvalidRatesException e) {
            Rate rate = new Rate();
            rate.setRates(rateService.getRecentRates());
            rate.setDate(StringUtil.getDate(LocalDateTime.now()));
            rateService.createRate(rate);
        }
    }
}
