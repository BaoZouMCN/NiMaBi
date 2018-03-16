package DAO;

import Model.Event;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

public class EventDAOImpl extends HibernateDaoSupport implements EventDAO {

    public void save(Event event){
        getHibernateTemplate().save(event);
    }

    public void update(Event event){
        getHibernateTemplate().update(event);
    }

    public void delete(Event event){
        getHibernateTemplate().delete(event);
    }

    public Event findEventByEventID(int eventID){
        List<Event> list = getHibernateTemplate().find("from event where event_id=?", eventID);
        return list.get(0);
    }

    public List<Event> findEventsByDescription(String description){
        return getHibernateTemplate().find("from event where description like `%?%`", description);
    }

}
