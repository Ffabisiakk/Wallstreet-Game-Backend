package pl.hollow.wallstreet.rate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.hollow.wallstreet.client.externalrates.dto.FullRatesDto;
import pl.hollow.wallstreet.client.externalrates.dto.RatesDto;

import java.math.BigDecimal;

@Document(collection = "rates")
class Rate {

    @Id
    private String date;
    private BigDecimal bitcoinRate;
    private BigDecimal hufRate;
    private BigDecimal czkRate;
    private BigDecimal ronRate;
    private BigDecimal sekRate;
    private BigDecimal rubRate;
    private BigDecimal chfRate;
    private BigDecimal eurRate;
    private BigDecimal bgnRate;
    private BigDecimal nokRate;
    private BigDecimal usdRate;
    private BigDecimal gbpRate;

    public Rate() {
    }

    public Rate(BigDecimal bitcoinRate, BigDecimal hufRate, BigDecimal czkRate, BigDecimal ronRate, BigDecimal sekRate, BigDecimal rubRate, BigDecimal chfRate, BigDecimal eurRate, BigDecimal bgnRate, BigDecimal nokRate, BigDecimal usdRate, BigDecimal gbpRate) {
        this.bitcoinRate = bitcoinRate;
        this.hufRate = hufRate;
        this.czkRate = czkRate;
        this.ronRate = ronRate;
        this.sekRate = sekRate;
        this.rubRate = rubRate;
        this.chfRate = chfRate;
        this.eurRate = eurRate;
        this.bgnRate = bgnRate;
        this.nokRate = nokRate;
        this.usdRate = usdRate;
        this.gbpRate = gbpRate;
    }

    public void setCurrencyRates(FullRatesDto fullRatesDto) {
        RatesDto ratesDto = fullRatesDto.getRates();
        this.hufRate = BigDecimal.valueOf(ratesDto.getHUF());
        this.czkRate = BigDecimal.valueOf(ratesDto.getCZK());
        this.ronRate = BigDecimal.valueOf(ratesDto.getRON());
        this.sekRate = BigDecimal.valueOf(ratesDto.getSEK());
        this.rubRate = BigDecimal.valueOf(ratesDto.getRUB());
        this.chfRate = BigDecimal.valueOf(ratesDto.getCHF());
        this.eurRate = BigDecimal.valueOf(ratesDto.getEUR());
        this.bgnRate = BigDecimal.valueOf(ratesDto.getBGN());
        this.nokRate = BigDecimal.valueOf(ratesDto.getNOK());
        this.usdRate = BigDecimal.valueOf(ratesDto.getUSD());
        this.gbpRate = BigDecimal.valueOf(ratesDto.getGBP());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getBitcoinRate() {
        return bitcoinRate;
    }

    public void setBitcoinRate(BigDecimal bitcoinRate) {
        this.bitcoinRate = bitcoinRate;
    }

    public BigDecimal getHufRate() {
        return hufRate;
    }

    public void setHufRate(BigDecimal hufRate) {
        this.hufRate = hufRate;
    }

    public BigDecimal getCzkRate() {
        return czkRate;
    }

    public void setCzkRate(BigDecimal czkRate) {
        this.czkRate = czkRate;
    }

    public BigDecimal getRonRate() {
        return ronRate;
    }

    public void setRonRate(BigDecimal ronRate) {
        this.ronRate = ronRate;
    }

    public BigDecimal getSekRate() {
        return sekRate;
    }

    public void setSekRate(BigDecimal sekRate) {
        this.sekRate = sekRate;
    }

    public BigDecimal getRubRate() {
        return rubRate;
    }

    public void setRubRate(BigDecimal rubRate) {
        this.rubRate = rubRate;
    }

    public BigDecimal getChfRate() {
        return chfRate;
    }

    public void setChfRate(BigDecimal chfRate) {
        this.chfRate = chfRate;
    }

    public BigDecimal getEurRate() {
        return eurRate;
    }

    public void setEurRate(BigDecimal eurRate) {
        this.eurRate = eurRate;
    }

    public BigDecimal getBgnRate() {
        return bgnRate;
    }

    public void setBgnRate(BigDecimal bgnRate) {
        this.bgnRate = bgnRate;
    }

    public BigDecimal getNokRate() {
        return nokRate;
    }

    public void setNokRate(BigDecimal nokRate) {
        this.nokRate = nokRate;
    }

    public BigDecimal getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(BigDecimal usdRate) {
        this.usdRate = usdRate;
    }

    public BigDecimal getGbpRate() {
        return gbpRate;
    }

    public void setGbpRate(BigDecimal gbpRate) {
        this.gbpRate = gbpRate;
    }
}
