package pl.hollow.wallstreet.rate.dto;

import java.time.LocalDate;

public class RateDto {

    private LocalDate date;
    private String bitcoinRate;
    private String hufRate;
    private String czkRate;
    private String ronRate;
    private String sekRate;
    private String rubRate;
    private String chfRate;
    private String eurRate;
    private String bgnRate;
    private String nokRate;
    private String usdRate;
    private String gbpRate;

    public RateDto() {
    }

    public RateDto(LocalDate date, String bitcoinRate, String hufRate, String czkRate, String ronRate, String sekRate, String rubRate, String chfRate, String eurRate, String bgnRate, String nokRate, String usdRate, String gbpRate) {
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public String getBitcoinRate() {
        return bitcoinRate;
    }

    public String getHufRate() {
        return hufRate;
    }

    public String getCzkRate() {
        return czkRate;
    }

    public String getRonRate() {
        return ronRate;
    }

    public String getSekRate() {
        return sekRate;
    }

    public String getRubRate() {
        return rubRate;
    }

    public String getChfRate() {
        return chfRate;
    }

    public String getEurRate() {
        return eurRate;
    }

    public String getBgnRate() {
        return bgnRate;
    }

    public String getNokRate() {
        return nokRate;
    }

    public String getUsdRate() {
        return usdRate;
    }

    public String getGbpRate() {
        return gbpRate;
    }
}
