package pl.hollow.wallstreet.client.externalrates.dto;

public class FullRatesDto {

    private RatesDto rates;
    private String base;
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
