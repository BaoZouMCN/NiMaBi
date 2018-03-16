package DAO;

import Model.CoinHistory;
import java.util.List;
import java.util.UUID;

public interface CoinHistoryDAO {

    public void save(CoinHistory coinHistory);

    public void update(CoinHistory coinHistory);

    public void delete(CoinHistory coinHistory);

    public CoinHistory findCoinHistoryByCoinUUID(UUID coin_uuid);

    public List<CoinHistory> findCoinHistoriesByEventID(int eventID);

}
