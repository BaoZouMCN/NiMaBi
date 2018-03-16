package DAO;

import Model.Coin;
import java.util.List;

public interface CoinDAO {

    public void save(Coin coin);

    public void update(Coin coin);

    public void delete(Coin coin);

    public Coin findCoinByCoinID(int coinID);

    public List<Coin> findCoinsByDescription(String description);

}
