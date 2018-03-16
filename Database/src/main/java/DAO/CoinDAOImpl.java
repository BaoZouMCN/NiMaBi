package DAO;

import Model.Coin;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

public class CoinDAOImpl extends HibernateDaoSupport implements CoinDAO {

    public void save(Coin coin) {
        getHibernateTemplate().save(coin);
    }

    public void update(Coin coin) {
        getHibernateTemplate().update(coin);
    }

    public void delete(Coin coin) {
        getHibernateTemplate().delete(coin);
    }

    public Coin findCoinByCoinID(int coinID) {
        List<Coin> list = getHibernateTemplate().find("from coin where coin_id=?", coinID);
        return list.get(0);
    }

    public List<Coin> findCoinsByDescription(String description) {
        return getHibernateTemplate().find("from coin where description like `%?%`", description);
    }
}
