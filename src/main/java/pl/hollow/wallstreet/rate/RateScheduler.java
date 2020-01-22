package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RateScheduler {

    private RateService rateService;

    @Autowired
    public RateScheduler(RateService rateService) {
        this.rateService = rateService;
    }

    @Scheduled(cron = "0 0 * ? * *")
    private void updateRates() {
        rateService.generateRecentRates();
    }

}
