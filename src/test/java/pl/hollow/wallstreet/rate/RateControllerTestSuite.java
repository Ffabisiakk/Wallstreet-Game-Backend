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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
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
    private RateFacade rateFacade;

    @Test
    public void shouldFetchEmptyRateList() throws Exception {
//        Given
        List<Rate> rateList = new ArrayList<>();
        when(rateFacade.getRates()).thenReturn(rateList);

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
        rate.setEurRate(new BigDecimal("4"));
        rateList.add(rate);
        when(rateFacade.getRates()).thenReturn(rateList);

//        When & Then
        mockMvc.perform(get("/rates").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].date", is("2020010112")))
                .andExpect(jsonPath("$[0].purchaseRates[0].name", is("bitcoinPurchaseRate")))
                .andExpect(jsonPath("$[0].purchaseRates[0].amount", is(0.001)))
                .andExpect(jsonPath("$[0].purchaseRates[7].name", is("eurPurchaseRate")))
                .andExpect(jsonPath("$[0].purchaseRates[7].amount", is(4)))
                .andExpect(jsonPath("$[0].saleRates[0].name", is("bitcoinSaleRate")))
                .andExpect(jsonPath("$[0].saleRates[0].amount", is(1000.0)))
                .andExpect(jsonPath("$[0].saleRates[7].name", is("eurSaleRate")))
                .andExpect(jsonPath("$[0].saleRates[7].amount", is(0.25)));
    }

    @Test
    public void shouldFetchRate() throws Exception {
//        Given
        Rate rate = new Rate();
        rate.setDate("2020010112");
        rate.setBitcoinRate(new BigDecimal("0.001"));
        rate.setEurRate(new BigDecimal("4"));
        when(rateFacade.getRate(anyString())).thenReturn(rate);

//        When & Then
        mockMvc.perform(get("/rates/anyString").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.date", is("2020010112")))
                .andExpect(jsonPath("$.purchaseRates[0].name", is("bitcoinPurchaseRate")))
                .andExpect(jsonPath("$.purchaseRates[0].amount", is(0.001)))
                .andExpect(jsonPath("$.purchaseRates[7].name", is("eurPurchaseRate")))
                .andExpect(jsonPath("$.purchaseRates[7].amount", is(4)))
                .andExpect(jsonPath("$.saleRates[0].name", is("bitcoinSaleRate")))
                .andExpect(jsonPath("$.saleRates[0].amount", is(1000.0)))
                .andExpect(jsonPath("$.saleRates[7].name", is("eurSaleRate")))
                .andExpect(jsonPath("$.saleRates[7].amount", is(0.25)));
    }

}