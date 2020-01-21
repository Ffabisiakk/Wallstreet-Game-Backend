package pl.hollow.wallstreet.client.externalrates.dto;

public class RatesDto {

    private String HUF;
    private String CZK;
    private String RON;
    private String SEK;
    private String RUB;
    private String CHF;
    private String EUR;
    private String BGN;
    private String NOK;
    private String USD;
    private String GBP;

    public RatesDto() {
    }

    public RatesDto(String HUF, String CZK, String RON, String SEK, String RUB, String CHF, String EUR, String BGN, String NOK, String USD, String GBP) {
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

    public String getHUF() {
        return HUF;
    }

    public String getCZK() {
        return CZK;
    }

    public String getRON() {
        return RON;
    }

    public String getSEK() {
        return SEK;
    }

    public String getRUB() {
        return RUB;
    }

    public String getCHF() {
        return CHF;
    }

    public String getEUR() {
        return EUR;
    }

    public String getBGN() {
        return BGN;
    }

    public String getNOK() {
        return NOK;
    }

    public String getUSD() {
        return USD;
    }

    public String getGBP() {
        return GBP;
    }
}


