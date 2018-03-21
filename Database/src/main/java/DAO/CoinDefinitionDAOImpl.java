package DAO;

import Model.CoinDefinition;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class CoinDefinitionDAOImpl extends HibernateDaoSupport implements CoinDefinitionDAO {

    public void save(CoinDefinition coin) {
        getHibernateTemplate().save(coin);
    }

    public void update(CoinDefinition coin) {
        getHibernateTemplate().update(coin);
    }

    public void delete(CoinDefinition coin) {
        getHibernateTemplate().delete(coin);
    }

    public CoinDefinition findCoinByCoinID(int coinID) {
        List<CoinDefinition> list = getHibernateTemplate().find("from coin_definition where coin_id=?", coinID);
        return list.get(0);
    }

    public List<CoinDefinition> listAllCoinDefinitions() {
        return getHibernateTemplate().find("from coin_definition");
    }

    public List<CoinDefinition> findCoinsByDescription(String description) {
        return getHibernateTemplate().find("from coin_definition where description like `%?%`", description);
    }

}
