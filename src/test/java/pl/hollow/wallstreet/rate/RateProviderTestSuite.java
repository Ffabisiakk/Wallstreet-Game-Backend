package pl.hollow.wallstreet.rate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.hollow.wallstreet.client.blockchaninfo.BlockchainInfoClient;
import pl.hollow.wallstreet.client.externalrates.ExternalRatesClient;
import pl.hollow.wallstreet.client.externalrates.dto.ExtFullRatesDto;
import pl.hollow.wallstreet.client.externalrates.dto.ExtRatesDto;
import pl.hollow.wallstreet.exception.InvalidRatesException;
import pl.hollow.wallstreet.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RateProviderTestSuite {

    @Autowired
    private RateProvider rateProvider;

    @MockBean
    private ExternalRatesClient ratesClient;
    @MockBean
    private BlockchainInfoClient bitcoinClient;

    @Test
    public void shouldGenerateRecentRate() throws InvalidRatesException {
//        Given
        ExtRatesDto extRatesDto = new ExtRatesDto(1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 10.5 ,11.5);
        ExtFullRatesDto extFullRatesDto = new ExtFullRatesDto(extRatesDto, "PLN", "1970010100");

        when(ratesClient.getCurrencyRates("PLN")).thenReturn(extFullRatesDto);
        when(bitcoinClient.getBitcoinCurrencyRate("PLN", "1000000000")).thenReturn(1000.0);

//        When
        Rate rate = rateProvider.generateRecentRate();

//        Then
        assertEquals(StringUtil.getDate(LocalDateTime.now()), rate.getDate());
        assertEquals(new BigDecimal("0.000001").setScale(50, RoundingMode.UP), rate.getRates().get("BTC"));
        assertEquals(new BigDecimal("7.5"), rate.getRates().get("EUR"));
    }
}