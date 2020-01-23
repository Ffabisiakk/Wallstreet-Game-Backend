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
        rate.setBitcoinRate(new BigDecimal("0.000001"));
        rate.setBgnRate(new BigDecimal("5"));
        rate.setEurRate(new BigDecimal("4"));
        rateList.add(rate);
        when(rateFacade.getRates()).thenReturn(rateList);

//        When & Then
        mockMvc.perform(get("/rates").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].date", is("2020010112")))
                .andExpect(jsonPath("$[0].bitcoinRate", is("0.000001")))
                .andExpect(jsonPath("$[0].bgnRate", is("5")))
                .andExpect(jsonPath("$[0].eurRate", is("4")));
    }

    @Test
    public void shouldFetchRate() throws Exception {
//        Given
        Rate rate = new Rate();
        rate.setDate("2020010112");
        rate.setBitcoinRate(new BigDecimal("0.000001"));
        rate.setBgnRate(new BigDecimal("5"));
        rate.setEurRate(new BigDecimal("4"));
        when(rateFacade.getRate(anyString())).thenReturn(rate);

//        When & Then
        mockMvc.perform(get("/rates/anyString").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.date", is("2020010112")))
                .andExpect(jsonPath("$.bitcoinRate", is("0.000001")))
                .andExpect(jsonPath("$.bgnRate", is("5")))
                .andExpect(jsonPath("$.eurRate", is("4")));
    }

}