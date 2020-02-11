package pl.hollow.wallstreet.client.externalrates;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hollow.wallstreet.client.externalrates.dto.ExtFullRatesDto;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ExternalRatesClientTest {

    @Autowired
    private ExternalRatesClient client;

    @Test
    public void shouldFetchCurrencyRates() {
//        When
        ExtFullRatesDto result = client.getCurrencyRates("PLN");

//        Then
        assertNotNull(result);
        assertNotNull(result.getRates());
        assertNotEquals(0, result.getRates().getEUR());
    }
}