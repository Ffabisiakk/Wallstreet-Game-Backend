package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RateScheduler {

    private RateService rateService;
    private RateProvider rateProvider;

    @Autowired
    public RateScheduler(RateService rateService, RateProvider rateProvider) {
        this.rateService = rateService;
        this.rateProvider = rateProvider;
    }

    @Scheduled(cron = "0 0 * ? * *")
    private void updateRates() {
        rateService.createRate(rateProvider.generateRecentRate());
    }
}
