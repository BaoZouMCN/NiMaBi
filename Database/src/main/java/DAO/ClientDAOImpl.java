package DAO;

import Model.Client;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

public class ClientDAOImpl extends HibernateDaoSupport implements ClientDAO {

    public void save(Client client) {
        getHibernateTemplate().save(client);
    }

    public void update(Client client) {
        getHibernateTemplate().update(client);
    }

    public void delete(Client client) {
        getHibernateTemplate().delete(client);
    }

    public Client findClientByBaozouID(String baozouID) {
        List<Client> list = getHibernateTemplate().find("from client where baozou_id=?", baozouID);
        return list.get(0);
    }

    public Client findClientByClientAccountID(int clientAccountID) {
        List<Client> list = getHibernateTemplate().find("from client where client_account_id=?", clientAccountID);
        return list.get(0);
    }

}
