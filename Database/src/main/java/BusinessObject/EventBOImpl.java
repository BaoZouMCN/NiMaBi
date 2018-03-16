package BusinessObject;

import DAO.EventDAO;
import Model.Event;
import java.util.List;

public class EventBOImpl implements EventBO {

    private EventDAO eventDAO;

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void save(Event event) {
        this.eventDAO.save(event);
    }

    public void update(Event event) {
        this.eventDAO.update(event);
    }

    public void delete(Event event) {
        this.eventDAO.delete(event);
    }

    public Event findEventByEventID(int eventID) {
        return this.eventDAO.findEventByEventID(eventID);
    }

    public List<Event> findEventsByDescription(String description) {
        return this.eventDAO.findEventsByDescription(description);
    }

}
