package pl.hollow.wallstreet.client.externalrates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.hollow.wallstreet.client.externalrates.dto.ExtFullRatesDto;
import pl.hollow.wallstreet.util.StringUtil;

@Component
public class ExternalRatesClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExternalRatesClient.class);

    private RestTemplate restTemplate;

    @Autowired
    public ExternalRatesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ExtFullRatesDto getCurrencyRates(String base) {
        String uri = StringUtil.format("https://api.exchangeratesapi.io/latest?base={}", base);
        try {
            return restTemplate.getForObject(uri, ExtFullRatesDto.class);
        } catch (RestClientException ex) {
            LOGGER.warn("Could't fetch currency rates.");
            return new ExtFullRatesDto();
        }
    }
}
