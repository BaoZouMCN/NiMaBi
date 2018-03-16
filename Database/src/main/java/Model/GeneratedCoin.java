package Model;

import java.io.Serializable;
import java.util.UUID;

public class GeneratedCoin implements Serializable {

    private int id;
    private UUID coin_uuid;
    private int current_event_id;

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

    public int getCurrent_event_id() {
        return current_event_id;
    }

    public void setCurrent_event_id(int current_event_id) {
        this.current_event_id = current_event_id;
    }
}
