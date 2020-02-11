package pl.hollow.wallstreet.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "users")
class User {

    @Id
    private String nickname;
    private String email;
    private Map<String, BigDecimal> wallet;

    public User() {
        wallet = new HashMap<>();
        wallet.put("PLN", new BigDecimal("1000"));
        wallet.put("BTC", BigDecimal.ZERO);
        wallet.put("BGN", BigDecimal.ZERO);
        wallet.put("CHF", BigDecimal.ZERO);
        wallet.put("CZK", BigDecimal.ZERO);
        wallet.put("EUR", BigDecimal.ZERO);
        wallet.put("GBP", BigDecimal.ZERO);
        wallet.put("HUF", BigDecimal.ZERO);
        wallet.put("NOK", BigDecimal.ZERO);
        wallet.put("RON", BigDecimal.ZERO);
        wallet.put("RUB", BigDecimal.ZERO);
        wallet.put("SEK", BigDecimal.ZERO);
        wallet.put("USD", BigDecimal.ZERO);
    }

    public User(String nickname, String email) {
        this();
        this.nickname = nickname;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, BigDecimal> getWallet() {
        return wallet;
    }

    public void setWallet(Map<String, BigDecimal> wallet) {
        this.wallet = wallet;
    }
}

