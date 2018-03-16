package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class CoinHistory implements Serializable {

    private int id;
    private UUID coin_uuid;
    private int event_id;
    private Timestamp time;

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

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        // Omitted as this is done at the time by mysql trigger
    }
}
