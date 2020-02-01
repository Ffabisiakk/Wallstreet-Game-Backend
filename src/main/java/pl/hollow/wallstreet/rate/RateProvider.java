package pl.hollow.wallstreet.rate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.client.blockchaninfo.BlockchainInfoClient;
import pl.hollow.wallstreet.client.externalrates.ExternalRatesClient;
import pl.hollow.wallstreet.client.externalrates.dto.FullRatesDto;
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

    public Rate generateRecentRate() {
        Rate rate = new Rate();
        FullRatesDto fullRatesDto = ratesClient.getCurrencyRates("PLN");
        String bitcoinsAmountForBillionPln = bitcoinClient.getBitcoinCurrencyRate("PLN", "1000000000");
        BigDecimal bitcoinRate = new BigDecimal("1000000000").divide(new BigDecimal(bitcoinsAmountForBillionPln), RoundingMode.UP);
        String date = StringUtil.getDate(LocalDateTime.now());
        rate.setDate(date);
        rate.setBitcoinRate(bitcoinRate);
        rate.setCurrencyRates(fullRatesDto);
        LOGGER.info("Generating most recent rate {}", date);
        return rate;
    }
}
