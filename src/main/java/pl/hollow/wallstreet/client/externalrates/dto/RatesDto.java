package pl.hollow.wallstreet.client.externalrates.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesDto implements Serializable {

    @JsonProperty(value = "HUF")
    private double HUF;
    @JsonProperty(value = "CZK")
    private double CZK;
    @JsonProperty(value = "RON")
    private double RON;
    @JsonProperty(value = "SEK")
    private double SEK;
    @JsonProperty(value = "RUB")
    private double RUB;
    @JsonProperty(value = "CHF")
    private double CHF;
    @JsonProperty(value = "EUR")
    private double EUR;
    @JsonProperty(value = "BGN")
    private double BGN;
    @JsonProperty(value = "NOK")
    private double NOK;
    @JsonProperty(value = "USD")
    private double USD;
    @JsonProperty(value = "GBP")
    private double GBP;

    public RatesDto() {
    }

    public RatesDto(double HUF, double CZK, double RON, double SEK, double RUB, double CHF, double EUR, double BGN, double NOK, double USD, double GBP) {
        this.HUF = HUF;
        this.CZK = CZK;
        this.RON = RON;
        this.SEK = SEK;
        this.RUB = RUB;
        this.CHF = CHF;
        this.EUR = EUR;
        this.BGN = BGN;
        this.NOK = NOK;
        this.USD = USD;
        this.GBP = GBP;
    }

    public double getHUF() {
        return HUF;
    }

    public void setHUF(double HUF) {
        this.HUF = HUF;
    }

    public double getCZK() {
        return CZK;
    }

    public void setCZK(double CZK) {
        this.CZK = CZK;
    }

    public double getRON() {
        return RON;
    }

    public void setRON(double RON) {
        this.RON = RON;
    }

    public double getSEK() {
        return SEK;
    }

    public void setSEK(double SEK) {
        this.SEK = SEK;
    }

    public double getRUB() {
        return RUB;
    }

    public void setRUB(double RUB) {
        this.RUB = RUB;
    }

    public double getCHF() {
        return CHF;
    }

    public void setCHF(double CHF) {
        this.CHF = CHF;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getBGN() {
        return BGN;
    }

    public void setBGN(double BGN) {
        this.BGN = BGN;
    }

    public double getNOK() {
        return NOK;
    }

    public void setNOK(double NOK) {
        this.NOK = NOK;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getGBP() {
        return GBP;
    }

    public void setGBP(double GBP) {
        this.GBP = GBP;
    }
}


