package DAO;

import Model.GeneratedCoin;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;
import java.util.UUID;

public class GeneratedCoinDAOImpl extends HibernateDaoSupport implements GeneratedCoinDAO {

    public void save(GeneratedCoin generatedCoin) {
        getHibernateTemplate().save(generatedCoin);
    }

    public void update(GeneratedCoin generatedCoin) {
        getHibernateTemplate().update(generatedCoin);
    }

    public void delete(GeneratedCoin generatedCoin) {
        getHibernateTemplate().delete(generatedCoin);
    }

    public GeneratedCoin findGeneratedCoinByCoinUUID(UUID coinUUID) {
        List<GeneratedCoin> list = getHibernateTemplate().find("from generated_coin where coin_uuid=?", coinUUID);
        return list.get(0);
    }

    public List<GeneratedCoin> findGeneratedCoinsByCurrentEventID(int currentEventID) {
        return getHibernateTemplate().find("from generated_coin where current_event_id=?", currentEventID);
    }

    public List<GeneratedCoin> findGeneratedCoinsByCoinType(int coinType) {
        return getHibernateTemplate().find("from generated_coin where coin_type=?", coinType);
    }

}
