package BusinessObject;

import Model.CoinDefinition;

import java.util.List;

public interface CoinDefinitionBO {

    public void save(CoinDefinition coin);

    public void update(CoinDefinition coin);

    public void delete(CoinDefinition coin);

    public CoinDefinition findCoinByCoinID(int coinID);

    public List<CoinDefinition> listAllCoinDefinitions();

    public List<CoinDefinition> findCoinsByDescription(String description);

}
