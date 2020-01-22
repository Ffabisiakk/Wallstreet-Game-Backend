package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RateFacade {

    private RateService rateService;

    @Autowired
    public RateFacade(RateService rateService) {
        this.rateService = rateService;
    }

    public List<Rate> getRates() {
        return rateService.getRates();
    }

    public Rate getRate(String date) {
        return rateService.getRate(date);
    }

    public void createRate(Rate rate) {
        rateService.createRate(rate);
    }

    public Rate updateRate(Rate rate) {
        return rateService.updateRate(rate);
    }

    public void deleteRate(String date) {
        rateService.deleteRate(date);
    }
}
