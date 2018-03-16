package DAO;

import Model.Event;
import java.util.List;

public interface EventDAO {

    public void save(Event event);

    public void update(Event event);

    public void delete(Event event);

    public Event findEventByEventID(int eventID);

    public List<Event> findEventsByDescription(String description);

}
