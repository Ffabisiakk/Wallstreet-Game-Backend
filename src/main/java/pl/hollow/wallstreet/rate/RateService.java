package pl.hollow.wallstreet.rate;

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
        Rate rate = new Rate();
        FullRatesDto fullRatesDto = ratesClient.getCurrencyRates("PLN");
        String bitcoinsAmountForBillionPln = bitcoinClient.getBitcoinCurrencyRate("PLN", "1000000000");
        BigDecimal bitcoinRate = BigDecimal.ONE.divide(new BigDecimal(bitcoinsAmountForBillionPln), RoundingMode.UP);

    }

    public Rate getRate(String date) {
        return rateRepository.findById(date)
                .orElseThrow(() -> new EntityNotFoundException("Rate history from " + StringUtil.getDate(date) +
                        " " + Integer.parseInt(date.substring(8)) + ":00 unavailable"));
    }

    public List<Rate> getRates() {
        return rateRepository.findAll();
    }

    public void createRate(Rate rate) {
        rateRepository.save(rate);
    }

    public Rate updateRate(Rate rate) {
        return rateRepository.save(rate);
    }

    public void deleteRate(String date) {
        rateRepository.deleteById(date);
    }
}
