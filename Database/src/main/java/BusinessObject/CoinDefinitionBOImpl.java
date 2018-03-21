package BusinessObject;

import DAO.CoinDefinitionDAO;
import Model.CoinDefinition;

import java.util.List;

public class CoinDefinitionBOImpl implements CoinDefinitionBO {

    private CoinDefinitionDAO coinDefinitionDAO;

    public void setCoinDAO(CoinDefinitionDAO coinDAO) {
        this.coinDefinitionDAO = coinDAO;
    }

    public void save(CoinDefinition coin) {
        this.coinDefinitionDAO.save(coin);
    }

    public void update(CoinDefinition coin) {
        this.coinDefinitionDAO.update(coin);
    }

    public void delete(CoinDefinition coin) {
        this.coinDefinitionDAO.delete(coin);
    }

    public CoinDefinition findCoinByCoinID(int coinID) {
        return this.coinDefinitionDAO.findCoinByCoinID(coinID);
    }

    public List<CoinDefinition> listAllCoinDefinitions() {
        return this.coinDefinitionDAO.listAllCoinDefinitions();
    }

    public List<CoinDefinition> findCoinsByDescription(String description) {
        return this.coinDefinitionDAO.findCoinsByDescription(description);
    }

}
