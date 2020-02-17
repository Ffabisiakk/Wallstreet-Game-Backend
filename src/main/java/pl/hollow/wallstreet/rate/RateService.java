package pl.hollow.wallstreet.rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.exception.EntityNotFoundException;
import pl.hollow.wallstreet.util.StringUtil;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class RateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateService.class);

    private RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public List<Rate> getRates() {
        LOGGER.info("Fetching list of all rates.");
        return rateRepository.findAll();
    }

    public Rate getRate(String date) {
        LOGGER.info("Fetching rate {}", date);
        return rateRepository.findById(date)
                .orElseThrow(() -> new EntityNotFoundException(StringUtil.format("Rate {} unavailable", date)));
    }

    public Map<String, BigDecimal> getRecentRates() {
        Rate recentRate = rateRepository.findAll().stream()
                .max(Comparator.comparing(Rate::getDate))
                .orElseThrow(() -> new EntityNotFoundException("Can't fetch any rates."));
        LOGGER.info("Fetching most recent rate {}", recentRate.getDate());
        return recentRate.getRates();
    }

    public void createRate(Rate rate) {
        LOGGER.info("Creating rate {}", rate.getDate());
        rateRepository.save(rate);
    }

}
