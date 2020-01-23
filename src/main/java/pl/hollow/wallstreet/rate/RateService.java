package pl.hollow.wallstreet.rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.client.blockchaninfo.BlockchainInfoClient;
import pl.hollow.wallstreet.client.externalrates.ExternalRatesClient;
import pl.hollow.wallstreet.client.externalrates.dto.FullRatesDto;
import pl.hollow.wallstreet.exception.EntityNotFoundException;
import pl.hollow.wallstreet.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
class RateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateService.class);

    private RateRepository rateRepository;
    private ExternalRatesClient ratesClient;
    private BlockchainInfoClient bitcoinClient;

    @Autowired
    public RateService(RateRepository rateRepository, ExternalRatesClient ratesClient, BlockchainInfoClient bitcoinClient) {
        this.rateRepository = rateRepository;
        this.ratesClient = ratesClient;
        this.bitcoinClient = bitcoinClient;
    }

    public void generateRecentRate() {
        Rate rate = new Rate();
        FullRatesDto fullRatesDto = ratesClient.getCurrencyRates("PLN");
        String bitcoinsAmountForBillionPln = bitcoinClient.getBitcoinCurrencyRate("PLN", "1000000000");
        BigDecimal bitcoinRate = new BigDecimal("1000000000").divide(new BigDecimal(bitcoinsAmountForBillionPln), RoundingMode.UP);
        String date = StringUtil.getDate(LocalDateTime.now());
        rate.setDate(date);
        rate.setBitcoinRate(bitcoinRate);
        rate.setCurrencyRates(fullRatesDto);
        LOGGER.info("Generating most recent rate {}", date);
        rateRepository.save(rate);
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
                    .filter(rate -> !rate.getDate().equals(mostRecentDate))
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
