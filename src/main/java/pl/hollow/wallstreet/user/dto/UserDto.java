package pl.hollow.wallstreet.user.dto;

import java.math.BigDecimal;
import java.util.Map;

public class UserDto {

    private String nickname;
    private String email;
    private Map<String, BigDecimal> wallet;

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
