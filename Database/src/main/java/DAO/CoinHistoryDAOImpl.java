package DAO;

import Model.CoinHistory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;
import java.util.UUID;

public class CoinHistoryDAOImpl extends HibernateDaoSupport implements CoinHistoryDAO {

    public void save(CoinHistory coinHistory) {
        getHibernateTemplate().save(coinHistory);
    }

    public void update(CoinHistory coinHistory) {
        getHibernateTemplate().update(coinHistory);
    }

    public void delete(CoinHistory coinHistory) {
        getHibernateTemplate().delete(coinHistory);
    }

    public CoinHistory findCoinHistoryByCoinUUID(UUID coinUUID) {
        List<CoinHistory> list = getHibernateTemplate().find("from coin_history where coin_uuid=?", coinUUID);
        return list.get(0);
    }

    public List<CoinHistory> findCoinHistoriesByEventID(int eventID) {
        return getHibernateTemplate().find("from coin_history where event_id=?", eventID);
    }

}
