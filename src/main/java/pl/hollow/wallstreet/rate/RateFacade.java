package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RateFacade {

    private RateService rateService;

    @Autowired
    public RateFacade(RateService rateService) {
        this.rateService = rateService;
    }

    
}
