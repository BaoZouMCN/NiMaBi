package BusinessObject;

import DAO.EventDefinitionDAO;
import Model.EventDefinition;

import java.util.List;

public class EventDefinitionBOImpl implements EventDefinitionBO {

    private EventDefinitionDAO eventDefinitionDAO;

    public void setEventDAO(EventDefinitionDAO eventDAO) {
        this.eventDefinitionDAO = eventDAO;
    }

    public void save(EventDefinition event) {
        this.eventDefinitionDAO.save(event);
    }

    public void update(EventDefinition event) {
        this.eventDefinitionDAO.update(event);
    }

    public void delete(EventDefinition event) {
        this.eventDefinitionDAO.delete(event);
    }

    public EventDefinition findEventByEventID(int eventID) {
        return this.eventDefinitionDAO.findEventByEventID(eventID);
    }

    public List<EventDefinition> listAllEventDefinitions() {
        return this.eventDefinitionDAO.listAllEventDefinitions();
    }

    public List<EventDefinition> findEventsByDescription(String description) {
        return this.eventDefinitionDAO.findEventsByDescription(description);
    }

}
