package Model;

import java.io.Serializable;

public class EventDefinition implements Serializable {

    private int event_definition_id;
    private String description;

    public int getEvent_definition_id() {
        return event_definition_id;
    }

    public void setEvent_definition_id(int event_definition_id) {
        this.event_definition_id = event_definition_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
