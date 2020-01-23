package pl.hollow.wallstreet.rate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.hollow.wallstreet.client.blockchaninfo.BlockchainInfoClient;
import pl.hollow.wallstreet.client.externalrates.ExternalRatesClient;
import pl.hollow.wallstreet.client.externalrates.dto.FullRatesDto;
import pl.hollow.wallstreet.client.externalrates.dto.RatesDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class RateServiceTestSuite {

    @Autowired
    private RateService rateService;

    @MockBean
    private RateRepository rateRepository;
    @MockBean
    private ExternalRatesClient ratesClient;
    @MockBean
    private BlockchainInfoClient bitcoinClient;

    @Test
    public void shouldGenerateRecentRate() {
//        Given
        RatesDto ratesDto = new RatesDto("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        FullRatesDto fullRatesDto = new FullRatesDto(ratesDto, "PLN", "1970010100");
        when(ratesClient.getCurrencyRates("PLN")).thenReturn(fullRatesDto);

        when(bitcoinClient.getBitcoinCurrencyRate("PLN", "1000000000")).thenReturn("1000000");

//        When
        rateService.generateRecentRate();

//        Then
        verify(ratesClient,times(1)).getCurrencyRates(anyString());
        verify(bitcoinClient,times(1)).getBitcoinCurrencyRate(anyString(),anyString());
        verify(rateRepository,times(1)).save(any());
    }

    @Test
    public void shouldFetchRecentRate() {
//        Given
        List<Rate> rateList = new ArrayList<>();
        Rate rate = new Rate();
        rate.setDate("2020010112");
        rateList.add(rate);
        Rate rate2 = new Rate();
        rate2.setDate("2020010114");
        rateList.add(rate2);
        Rate rate3 = new Rate();
        rate3.setDate("2020010113");
        rateList.add(rate3);
        when(rateRepository.findAll()).thenReturn(rateList);

//        When
        Rate fetchRate = rateService.getRecentRate();

//        Then
        assertNotNull(fetchRate);
        assertEquals("2020010114", fetchRate.getDate());
    }
}