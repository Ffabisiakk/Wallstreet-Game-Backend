package pl.hollow.wallstreet.rate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

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