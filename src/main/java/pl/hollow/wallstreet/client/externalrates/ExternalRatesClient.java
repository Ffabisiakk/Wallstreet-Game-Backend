package pl.hollow.wallstreet.client.externalrates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.hollow.wallstreet.client.externalrates.dto.FullRatesDto;
import pl.hollow.wallstreet.util.StringUtil;

@Component
public class ExternalRatesClient {

    private RestTemplate restTemplate;

    @Autowired
    public ExternalRatesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FullRatesDto getCurrencyRates(String base) {
        String uri = StringUtil.format("https://api.exchangeratesapi.io/latest?base={}", base);
        return restTemplate.getForObject(uri, FullRatesDto.class);
    }
}
