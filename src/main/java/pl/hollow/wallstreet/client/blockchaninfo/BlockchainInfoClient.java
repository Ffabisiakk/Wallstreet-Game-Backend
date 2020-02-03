package pl.hollow.wallstreet.client.blockchaninfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.hollow.wallstreet.util.StringUtil;

@Component
public class BlockchainInfoClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(BlockchainInfoClient.class);

    private RestTemplate restTemplate;

    @Autowired
    public BlockchainInfoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double getBitcoinCurrencyRate(String currency, String amount) {
        String uri = StringUtil.format("https://blockchain.info/tobtc?currency={}&value={}", currency, amount);
        try {
            String result = restTemplate.getForObject(uri, String.class);
            return Double.parseDouble(result.replace(",", ""));
        } catch (RestClientException e) {
            LOGGER.warn("Could't fetch Bitcoin rate.");
            return -1.0;
        } catch (NullPointerException e) {
            LOGGER.warn("Empty result set.");
            return -1.0;
        }
    }
}
