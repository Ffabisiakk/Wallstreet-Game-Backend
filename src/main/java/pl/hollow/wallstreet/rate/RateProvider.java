package pl.hollow.wallstreet.rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.client.blockchaninfo.BlockchainInfoClient;
import pl.hollow.wallstreet.client.externalrates.ExternalRatesClient;
import pl.hollow.wallstreet.client.externalrates.dto.FullRatesDto;
import pl.hollow.wallstreet.exception.InvalidRatesException;
import pl.hollow.wallstreet.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
class RateProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(RateProvider.class);

    private ExternalRatesClient ratesClient;
    private BlockchainInfoClient bitcoinClient;

    @Autowired
    public RateProvider(ExternalRatesClient ratesClient, BlockchainInfoClient bitcoinClient) {
        this.ratesClient = ratesClient;
        this.bitcoinClient = bitcoinClient;
    }

    public Rate generateRecentRate() throws InvalidRatesException {
        String date = StringUtil.getDate(LocalDateTime.now());
        BigDecimal bitcoinRate = getBitcoinRate();
        FullRatesDto fullRatesDto = getCurrencyRates();

        Rate rate = new Rate();
        rate.setDate(date);
        rate.setBitcoinRate(bitcoinRate);
        rate.setCurrencyRates(fullRatesDto);

        LOGGER.info("Generating most recent rate {}", date);
        return rate;
    }

    private FullRatesDto getCurrencyRates() throws InvalidRatesException {
        FullRatesDto fullRatesDto = ratesClient.getCurrencyRates("PLN");
        if (fullRatesDto.getRates() == null) {
            throw new InvalidRatesException("Failed to get currency rates.");
        }
        return fullRatesDto;
    }

    private BigDecimal getBitcoinRate() throws InvalidRatesException {
        Double bitcoinsAmountForBillionPln = bitcoinClient.getBitcoinCurrencyRate("PLN", "1000000000");
        if (bitcoinsAmountForBillionPln == -1) {
            throw new InvalidRatesException("Failed to get bitcoin rate.");
        }
        return new BigDecimal(bitcoinsAmountForBillionPln).setScale(50,RoundingMode.UP).divide(new BigDecimal("1000000000"), RoundingMode.UP);
    }
}
