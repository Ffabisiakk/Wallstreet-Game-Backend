package pl.hollow.wallstreet.rate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ReflectionUtils;
import pl.hollow.wallstreet.client.externalrates.dto.ExtFullRatesDto;
import pl.hollow.wallstreet.client.externalrates.dto.ExtRatesDto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "rates")
class Rate {

    @Id
    private String date;
    private Map<String, BigDecimal> rates;

    public Rate() {
        rates = new HashMap<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setBitcoinRate(BigDecimal bitcoinRate) {
        rates.put("BTC", bitcoinRate);
    }

    public void setCurrencyRates(ExtFullRatesDto extFullRatesDto) {
        ExtRatesDto extRatesDto = extFullRatesDto.getRates();
        ReflectionUtils.doWithFields(extRatesDto.getClass(), field -> {
            field.setAccessible(true);
            rates.put(field.getName(), BigDecimal.valueOf((double) field.get(extRatesDto)));
        });
    }
}
