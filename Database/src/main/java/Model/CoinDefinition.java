package Model;

import java.io.Serializable;

public class CoinDefinition implements Serializable {

    private int coin_definition_id;
    private String description;

    public int getCoin_definition_id() {
        return coin_definition_id;
    }

    public void setCoin_definition_id(int coin_definition_id) {
        this.coin_definition_id = coin_definition_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
