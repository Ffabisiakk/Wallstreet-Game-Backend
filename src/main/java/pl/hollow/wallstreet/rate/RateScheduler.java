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
    private RateProvider rateProvider;
    private Rate rateCache;

    @Autowired
    public RateScheduler(RateService rateService, RateProvider rateProvider) {
        this.rateService = rateService;
        this.rateProvider = rateProvider;
    }

    public void setRateCache(Rate rateCache) {
        this.rateCache = rateCache;
    }

//    init after 30s due to RateServiceTestSuite collision with @PostConstruct
    @Scheduled(initialDelay = 1000 * 30, fixedDelay = Long.MAX_VALUE)
    public void initRateCache() {
        rateCache = rateService.getRecentRate();
    }

    @Scheduled(cron = "0 0 * ? * *")
    public void updateRates() {
        try {
            Rate rate = rateProvider.generateRecentRate();
            rateService.createRate(rate);
            setRateCache(rate);
        } catch (InvalidRatesException e) {
            rateCache.setDate(StringUtil.getDate(LocalDateTime.now()));
            rateService.createRate(rateCache);
        }
    }
}
