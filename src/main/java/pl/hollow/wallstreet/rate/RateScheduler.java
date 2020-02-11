package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.hollow.wallstreet.exception.InvalidRatesException;
import pl.hollow.wallstreet.util.StringUtil;

import java.time.LocalDateTime;

@Component
public class RateScheduler {

    private RateService rateService;
    private RateCaches rateCaches;
    private RateProvider rateProvider;

    @Autowired
    public RateScheduler(RateService rateService, RateCaches rateCaches, RateProvider rateProvider) {
        this.rateService = rateService;
        this.rateCaches = rateCaches;
        this.rateProvider = rateProvider;
    }

    //    init after 30s due to RateServiceTestSuite collision with @PostConstruct
    @Scheduled(initialDelay = 1000 * 30, fixedDelay = Long.MAX_VALUE)
    public void initRateCache() {
        Rate recentRate = rateService.getRecentRate();
        rateCaches.setRateCache(recentRate.getRates());
    }

    @Scheduled(cron = "0 0 * ? * *")
//    @Scheduled(fixedDelay = 10 * 1000)
    public void updateRates() {
        try {
            Rate rate = rateProvider.generateRecentRate();
            rateService.createRate(rate);
            rateCaches.setRateCache(rate.getRates());
        } catch (InvalidRatesException e) {
            Rate rate = new Rate();
            rate.setRates(rateCaches.getRateCache());
            rate.setDate(StringUtil.getDate(LocalDateTime.now()));
            rateService.createRate(rate);
        }
    }
}
