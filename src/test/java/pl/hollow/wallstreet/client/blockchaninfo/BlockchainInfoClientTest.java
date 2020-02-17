package pl.hollow.wallstreet.client.blockchaninfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class BlockchainInfoClientTest {

    @Autowired
    private BlockchainInfoClient client;

    @Test
    public void shouldFetchFlag() {
//        When
        Double result = client.getBitcoinCurrencyRate("PLN", "test");

//        Then
        assertEquals(-1, result);
    }

    @Test
    public void shouldFetchBitcoinRates() {
//        When
        Double result = client.getBitcoinCurrencyRate("PLN", "1");

//        Then
        assertNotEquals(-1, result);
    }

    @Test
    public void shouldFetchBitcoinRatesBigValue() {
//        When
        Double result = client.getBitcoinCurrencyRate("PLN", String.valueOf(Integer.MAX_VALUE));

//        Then
        assertNotEquals(-1, result);
    }
}