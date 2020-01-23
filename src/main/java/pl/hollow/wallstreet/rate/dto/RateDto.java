package pl.hollow.wallstreet.rate.dto;

public class RateDto {

    private String date;
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

    public RateDto(String date, String bitcoinRate, String hufRate, String czkRate, String ronRate, String sekRate, String rubRate, String chfRate, String eurRate, String bgnRate, String nokRate, String usdRate, String gbpRate) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBitcoinRate() {
        return bitcoinRate;
    }

    public void setBitcoinRate(String bitcoinRate) {
        this.bitcoinRate = bitcoinRate;
    }

    public String getHufRate() {
        return hufRate;
    }

    public void setHufRate(String hufRate) {
        this.hufRate = hufRate;
    }

    public String getCzkRate() {
        return czkRate;
    }

    public void setCzkRate(String czkRate) {
        this.czkRate = czkRate;
    }

    public String getRonRate() {
        return ronRate;
    }

    public void setRonRate(String ronRate) {
        this.ronRate = ronRate;
    }

    public String getSekRate() {
        return sekRate;
    }

    public void setSekRate(String sekRate) {
        this.sekRate = sekRate;
    }

    public String getRubRate() {
        return rubRate;
    }

    public void setRubRate(String rubRate) {
        this.rubRate = rubRate;
    }

    public String getChfRate() {
        return chfRate;
    }

    public void setChfRate(String chfRate) {
        this.chfRate = chfRate;
    }

    public String getEurRate() {
        return eurRate;
    }

    public void setEurRate(String eurRate) {
        this.eurRate = eurRate;
    }

    public String getBgnRate() {
        return bgnRate;
    }

    public void setBgnRate(String bgnRate) {
        this.bgnRate = bgnRate;
    }

    public String getNokRate() {
        return nokRate;
    }

    public void setNokRate(String nokRate) {
        this.nokRate = nokRate;
    }

    public String getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(String usdRate) {
        this.usdRate = usdRate;
    }

    public String getGbpRate() {
        return gbpRate;
    }

    public void setGbpRate(String gbpRate) {
        this.gbpRate = gbpRate;
    }
}
