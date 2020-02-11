package pl.hollow.wallstreet.rate;

import org.springframework.stereotype.Component;

@Component
public class RateCaches {

    private Rate rateCache;

    public Rate getRateCache() {
        return rateCache;
    }

    public void setRateCache(Rate rateCache) {
        this.rateCache = rateCache;
    }
}
