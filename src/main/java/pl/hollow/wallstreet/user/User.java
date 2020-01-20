package pl.hollow.wallstreet.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
class User {

    @Id
    private String id;

    private String nickname;
    private String email;
    private Long cash;
    private Float bitcoins;

    public User() {
    }

    public User(String nickname, String email, Long cash, Float bitcoins) {
        this.nickname = nickname;
        this.email = email;
        this.cash = cash;
        this.bitcoins = bitcoins;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getCash() {
        return cash;
    }

    public void setCash(Long cash) {
        this.cash = cash;
    }

    public Float getBitcoins() {
        return bitcoins;
    }

    public void setBitcoins(Float bitcoins) {
        this.bitcoins = bitcoins;
    }
}
