package Model;

import java.io.Serializable;

public class CoinDefinition implements Serializable {

    private int coin_id;
    private String description;

    public int getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(int coin_id) {
        this.coin_id = coin_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
