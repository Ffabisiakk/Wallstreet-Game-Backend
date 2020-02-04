package pl.hollow.wallstreet.rate.dto;

import java.util.List;

public class RateDto {

    private String date;
    private List<SingleRateDto> purchaseRates;
    private List<SingleRateDto> saleRates;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SingleRateDto> getPurchaseRates() {
        return purchaseRates;
    }

    public void setPurchaseRates(List<SingleRateDto> purchaseRates) {
        this.purchaseRates = purchaseRates;
    }

    public List<SingleRateDto> getSaleRates() {
        return saleRates;
    }

    public void setSaleRates(List<SingleRateDto> saleRates) {
        this.saleRates = saleRates;
    }
}
