package pl.hollow.wallstreet.rate.dto;

import java.math.BigDecimal;
import java.util.Map;

public class RateDto {

    private String date;

    private Map<String, BigDecimal> purchaseRates;
    private Map<String, BigDecimal> saleRates;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, BigDecimal> getPurchaseRates() {
        return purchaseRates;
    }

    public void setPurchaseRates(Map<String, BigDecimal> purchaseRates) {
        this.purchaseRates = purchaseRates;
    }

    public Map<String, BigDecimal> getSaleRates() {
        return saleRates;
    }

    public void setSaleRates(Map<String, BigDecimal> saleRates) {
        this.saleRates = saleRates;
    }
}
