package pl.hollow.wallstreet.rate;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class RateCaches {

    private Map<String, BigDecimal> rateCache;

    public Map<String, BigDecimal> getRateCache() {
        return rateCache;
    }

    public void setRateCache(Map<String, BigDecimal> rateCache) {
        this.rateCache = rateCache;
    }
}
