package BusinessObject;

import DAO.CoinHistoryDAO;
import Model.CoinHistory;
import java.util.List;
import java.util.UUID;

public class CoinHistoryBOImpl implements CoinHistoryBO {

    private CoinHistoryDAO coinHistoryDAO;

    public void setCoinHistoryDAO(CoinHistoryDAO coinHistoryDAO) {
        this.coinHistoryDAO = coinHistoryDAO;
    }

    public void save(CoinHistory coinHistory) {
        this.coinHistoryDAO.save(coinHistory);
    }

    public void update(CoinHistory coinHistory) {
        this.coinHistoryDAO.update(coinHistory);
    }

    public void delete(CoinHistory coinHistory) {
        this.coinHistoryDAO.delete(coinHistory);
    }

    public CoinHistory findCoinHistoryByCoinUUID(UUID coinUUID) {
        return this.coinHistoryDAO.findCoinHistoryByCoinUUID(coinUUID);
    }

    public List<CoinHistory> findCoinHistoriesByEventID(int eventID) {
        return this.coinHistoryDAO.findCoinHistoriesByEventID(eventID);
    }

}
