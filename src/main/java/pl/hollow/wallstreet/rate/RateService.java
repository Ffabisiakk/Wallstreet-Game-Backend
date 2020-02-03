package pl.hollow.wallstreet.rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.exception.EntityNotFoundException;
import pl.hollow.wallstreet.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
class RateService {

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

    public Rate getRecentRate() {
        List<Rate> rateList = rateRepository.findAll();
        List<String> dateList = rateList.stream()
                .map(Rate::getDate)
                .sorted()
                .collect(Collectors.toList());
        if (dateList.size() != 0) {
            String mostRecentDate = dateList.get(0);
            LOGGER.info("Fetching most recent rate {}", mostRecentDate);
            return rateList.stream()
                    .filter(rate -> rate.getDate().equals(mostRecentDate))
                    .collect(Collectors.toList()).get(0);
        } else {
            throw new EntityNotFoundException("Can't fetch any rates.");
        }
    }

    public void createRate(Rate rate) {
        LOGGER.info("Creating rate {}", rate.getDate());
        rateRepository.save(rate);
    }

    public Rate updateRate(Rate rate) {
        LOGGER.info("Updating rate {}", rate.getDate());
        return rateRepository.save(rate);
    }

    public void deleteRate(String date) {
        LOGGER.info("Deleting rate {}", date);
        rateRepository.deleteById(date);
    }
}
