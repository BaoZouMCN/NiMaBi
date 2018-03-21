package Model;

import java.io.Serializable;
import java.util.UUID;

public class GeneratedCoin implements Serializable {

    private int id;
    private UUID coin_uuid;
    private int coin_definition_id;
    private int current_event_id;

    public GeneratedCoin(UUID coin_uuid, int coin_definition_id, int current_event_id) {
        this.coin_uuid = coin_uuid;
        this.coin_definition_id = coin_definition_id;
        this.current_event_id = current_event_id;
    }

    public GeneratedCoin(UUID coin_uuid, int coin_definition_id) {
        this.coin_uuid = coin_uuid;
        this.coin_definition_id = coin_definition_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getCoin_uuid() {
        return coin_uuid;
    }

    public void setCoin_uuid(UUID coin_uuid) {
        this.coin_uuid = coin_uuid;
    }

    public int getCoin_definition_id() {
        return coin_definition_id;
    }

    public void setCoin_definition_id(int coin_definition_id) {
        this.coin_definition_id = coin_definition_id;
    }

    public int getCurrent_event_id() {
        return current_event_id;
    }

    public void setCurrent_event_id(int current_event_id) {
        this.current_event_id = current_event_id;
    }
}
