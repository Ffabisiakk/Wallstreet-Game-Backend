package pl.hollow.wallstreet.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "users")
class User {

    @Id
    private String nickname;
    private String email;
    private BigDecimal cash;
    private BigDecimal bitcoin;

    public User() {
    }

    public User(String email, BigDecimal cash, BigDecimal bitcoin) {
        this.email = email;
        this.cash = cash;
        this.bitcoin = bitcoin;
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

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(BigDecimal bitcoin) {
        this.bitcoin = bitcoin;
    }
}
