package DAO;

import Model.EventDefinition;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class EventDefinitionDAOImpl extends HibernateDaoSupport implements EventDefinitionDAO {

    public void save(EventDefinition event) {
        getHibernateTemplate().save(event);
    }

    public void update(EventDefinition event) {
        getHibernateTemplate().update(event);
    }

    public void delete(EventDefinition event) {
        getHibernateTemplate().delete(event);
    }

    public EventDefinition findEventByEventID(int eventID) {
        List<EventDefinition> list = getHibernateTemplate().find("from event_definition where event_id=?", eventID);
        return list.get(0);
    }

    public List<EventDefinition> listAllEventDefinitions() {
        return getHibernateTemplate().find("from event_definition");
    }

    public List<EventDefinition> findEventsByDescription(String description) {
        return getHibernateTemplate().find("from event_definition where description like `%?%`", description);
    }

}
