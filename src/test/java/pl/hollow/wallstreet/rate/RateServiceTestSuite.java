package pl.hollow.wallstreet.rate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class RateServiceTestSuite {

    @Autowired
    private RateService rateService;

    @MockBean
    private RateRepository rateRepository;

    @Test
    public void shouldFetchRecentRate() {
//        Given
        List<Rate> rateList = new ArrayList<>();

        Rate rate = new Rate();
        rate.setDate("3000010112");
        rate.setBitcoinRate(BigDecimal.ZERO);
        rateList.add(rate);

        Rate rate2 = new Rate();
        rate2.setDate("3000010114");
        rate2.setBitcoinRate(BigDecimal.ONE);
        rateList.add(rate2);

        Rate rate3 = new Rate();
        rate3.setDate("3000010113");
        rate3.setBitcoinRate(BigDecimal.TEN);
        rateList.add(rate3);

        when(rateRepository.findAll()).thenReturn(rateList);

//        When
        Map<String, BigDecimal> fetchRate = rateService.getRecentRates();

//        Then
        assertNotNull(fetchRate);
        assertEquals(BigDecimal.ONE, fetchRate.get("BTC"));
    }
}