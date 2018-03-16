package BusinessObject;

import DAO.CoinDAO;
import Model.Coin;
import java.util.List;

public class CoinBOImpl implements CoinBO {

    private CoinDAO coinDAO;

    public void setCoinDAO(CoinDAO coinDAO) {
        this.coinDAO = coinDAO;
    }

    public void save(Coin coin) {
        this.coinDAO.save(coin);
    }

    public void update(Coin coin) {
        this.coinDAO.update(coin);
    }

    public void delete(Coin coin) {
        this.coinDAO.delete(coin);
    }

    public Coin findCoinByCoinID(int coinID) {
        return this.coinDAO.findCoinByCoinID(coinID);
    }

    public List<Coin> findCoinsByDescription(String description) {
        return this.coinDAO.findCoinsByDescription(description);
    }

}
