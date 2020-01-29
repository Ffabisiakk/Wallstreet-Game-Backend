package pl.hollow.wallstreet.client.externalrates.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullRatesDto implements Serializable {

    @JsonProperty(value = "rates")
    private RatesDto rates;
    @JsonProperty(value = "base")
    private String base;
    @JsonProperty(value = "data")
    private String date;

    public FullRatesDto() {
    }

    public FullRatesDto(RatesDto rates, String base, String date) {
        this.rates = rates;
        this.base = base;
        this.date = date;
    }

    public RatesDto getRates() {
        return rates;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }
}
