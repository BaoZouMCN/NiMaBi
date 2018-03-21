package BusinessObject;

import DAO.GeneratedCoinDAO;
import Model.GeneratedCoin;

import java.util.List;
import java.util.UUID;

public class GeneratedCoinBOImpl implements GeneratedCoinBO {

    private GeneratedCoinDAO generatedCoinDAO;

    public void setGeneratedCoinDAO(GeneratedCoinDAO generatedCoinDAO) {
        this.generatedCoinDAO = generatedCoinDAO;
    }

    public void save(GeneratedCoin generatedCoin) {
        this.generatedCoinDAO.save(generatedCoin);
    }

    public void update(GeneratedCoin generatedCoin) {
        this.generatedCoinDAO.update(generatedCoin);
    }

    public void delete(GeneratedCoin generatedCoin) {
        this.generatedCoinDAO.delete(generatedCoin);
    }

    public GeneratedCoin findGeneratedCoinByCoinUUID(UUID coinUUID) {
        return this.generatedCoinDAO.findGeneratedCoinByCoinUUID(coinUUID);
    }

    public List<GeneratedCoin> findGeneratedCoinsByCurrentEventID(int currentEventID) {
        return this.generatedCoinDAO.findGeneratedCoinsByCurrentEventID(currentEventID);
    }

    public List<GeneratedCoin> findGeneratedCoinsByCoinType(int coinType) {
        return this.generatedCoinDAO.findGeneratedCoinsByCoinType(coinType);
    }

}
