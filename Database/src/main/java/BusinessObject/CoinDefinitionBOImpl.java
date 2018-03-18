package BusinessObject;

import DAO.CoinDefinitionDAO;
import Model.CoinDefinition;
import java.util.List;

public class CoinDefinitionBOImpl implements CoinDefinitionBO {

    private CoinDefinitionDAO coinDAO;

    public void setCoinDAO(CoinDefinitionDAO coinDAO) {
        this.coinDAO = coinDAO;
    }

    public void save(CoinDefinition coin) {
        this.coinDAO.save(coin);
    }

    public void update(CoinDefinition coin) {
        this.coinDAO.update(coin);
    }

    public void delete(CoinDefinition coin) {
        this.coinDAO.delete(coin);
    }

    public CoinDefinition findCoinByCoinID(int coinID) {
        return this.coinDAO.findCoinByCoinID(coinID);
    }

    public List<CoinDefinition> findCoinsByDescription(String description) {
        return this.coinDAO.findCoinsByDescription(description);
    }

}
