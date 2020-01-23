package pl.hollow.wallstreet.rate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RateTestSuite {

    @Autowired
    private RateRepository rateRepository;

    @Test
    public void shouldFetchRate() {
//        Given
        Rate rate = new Rate();
        rateRepository.save(rate);
        String date = rate.getDate();

//        When
        Optional<Rate> fetchedRateOpt = rateRepository.findById(date);

//        Then
        assertTrue(fetchedRateOpt.isPresent());
        assertEquals(date, fetchedRateOpt.get().getDate());

//        CleanUp
        rateRepository.deleteById(date);
    }

}