package DAO;

import Model.EventDefinition;

import java.util.List;

public interface EventDefinitionDAO {

    public void save(EventDefinition event);

    public void update(EventDefinition event);

    public void delete(EventDefinition event);

    public EventDefinition findEventByEventID(int eventID);

    public List<EventDefinition> listAllEventDefinitions();

    public List<EventDefinition> findEventsByDescription(String description);

}
