package pl.hollow.wallstreet.client.externalrates.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtFullRatesDto implements Serializable {

    @JsonProperty(value = "rates")
    private ExtRatesDto rates;
    @JsonProperty(value = "base")
    private String base;
    @JsonProperty(value = "data")
    private String date;

    public ExtFullRatesDto() {
    }

    public ExtFullRatesDto(ExtRatesDto rates, String base, String date) {
        this.rates = rates;
        this.base = base;
        this.date = date;
    }

    public ExtRatesDto getRates() {
        return rates;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }
}
