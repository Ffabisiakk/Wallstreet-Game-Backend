package pl.hollow.wallstreet.rate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RateControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RateService rateService;

    @Test
    public void shouldFetchEmptyRateList() throws Exception {
//        Given
        when(rateService.getRates()).thenReturn(new ArrayList<>());

//        When & Then
        mockMvc.perform(get("/rates").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchRateList() throws Exception {
//        Given
        List<Rate> rateList = new ArrayList<>();
        Rate rate = new Rate();
        rate.setDate("2020010112");
        rate.setBitcoinRate(new BigDecimal("0.001"));
        rate.getRates().put("EUR", new BigDecimal("4"));
        rateList.add(rate);
        when(rateService.getRates()).thenReturn(rateList);

//        When & Then
        mockMvc.perform(get("/rates").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].date", is("2020-01-01 12:00")))
                .andExpect(jsonPath("$[0].purchaseRates", aMapWithSize(2)))
                .andExpect(jsonPath("$[0].purchaseRates.BTC", is(0.001)))
                .andExpect(jsonPath("$[0].purchaseRates.EUR", is(4)))
                .andExpect(jsonPath("$[0].saleRates", aMapWithSize(2)))
                .andExpect(jsonPath("$[0].saleRates.BTC", is(1000.0)))
                .andExpect(jsonPath("$[0].saleRates.EUR", is(0.25)));
    }

    @Test
    public void shouldFetchRate() throws Exception {
//        Given
        Rate rate = new Rate();
        rate.setDate("2020010112");
        rate.setBitcoinRate(new BigDecimal("0.001"));
        rate.getRates().put("EUR", new BigDecimal("4"));
        when(rateService.getRate(anyString())).thenReturn(rate);

//        When & Then
        mockMvc.perform(get("/rates/2020-01-01 12:00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.date", is("2020-01-01 12:00")))
                .andExpect(jsonPath("$.purchaseRates", aMapWithSize(2)))
                .andExpect(jsonPath("$.purchaseRates.BTC", is(0.001)))
                .andExpect(jsonPath("$.purchaseRates.EUR", is(4)))
                .andExpect(jsonPath("$.saleRates", aMapWithSize(2)))
                .andExpect(jsonPath("$.saleRates.BTC", is(1000.0)))
                .andExpect(jsonPath("$.saleRates.EUR", is(0.25)));
    }

}