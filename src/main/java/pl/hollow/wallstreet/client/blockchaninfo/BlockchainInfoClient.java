package pl.hollow.wallstreet.client.blockchaninfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.hollow.wallstreet.util.StringUtil;

@Component
public class BlockchainInfoClient {

    private RestTemplate restTemplate;

    @Autowired
    public BlockchainInfoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getBitcoinCurrencyRate(String currency, String amount) {
        String uri = StringUtil.format("https://blockchain.info/tobtc?currency={}&value={}", currency, amount);
        return restTemplate.getForObject(uri, String.class);
    }
}
