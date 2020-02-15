package pl.hollow.wallstreet.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Document(collection = "users")
public class User {

    @Id
    private String nickname;
    private String email;
    private String password;
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private boolean isEnabled;
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

    public User(String nickname, String email, String password, Set<? extends GrantedAuthority> grantedAuthorities, boolean isEnabled) {
        super();
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.isEnabled = isEnabled;
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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<? extends GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Set<? extends GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
}

