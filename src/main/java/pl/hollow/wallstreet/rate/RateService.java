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
import java.util.List;

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

    public void generateRecentRates() {
        LOGGER.info("Creating most recent rate");
        Rate rate = new Rate();
        FullRatesDto fullRatesDto = ratesClient.getCurrencyRates("PLN");
        String bitcoinsAmountForBillionPln = bitcoinClient.getBitcoinCurrencyRate("PLN", "1000000000");
        BigDecimal bitcoinRate = BigDecimal.ONE.divide(new BigDecimal(bitcoinsAmountForBillionPln), RoundingMode.UP);

    }

    public List<Rate> getRates() {
        LOGGER.info("Fetching list of all rates.");
        return rateRepository.findAll();
    }

    public Rate getRate(String date) {
        LOGGER.info("Fetching rate {}", date);
        return rateRepository.findById(date)
                .orElseThrow(() -> new EntityNotFoundException("Rate history from " + StringUtil.getDate(date) +
                        " " + Integer.parseInt(date.substring(8)) + ":00 unavailable"));
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
