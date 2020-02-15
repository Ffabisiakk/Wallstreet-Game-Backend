package pl.hollow.wallstreet.user.dto;

import java.math.BigDecimal;
import java.util.Map;

public class UserDto {

    private String nickname;
    private String email;
    private char[] password;
    private String role;
    private boolean isEnabled;
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

    public String getPassword() {
        return new String(password);
    }

    public void setPassword(String password) {
        this.password = password.toCharArray();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Map<String, BigDecimal> getWallet() {
        return wallet;
    }

    public void setWallet(Map<String, BigDecimal> wallet) {
        this.wallet = wallet;
    }
}
