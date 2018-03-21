package BusinessObject;

import Model.GeneratedCoin;

import java.util.List;
import java.util.UUID;

public interface GeneratedCoinBO {

    public void save(GeneratedCoin generatedCoin);

    public void update(GeneratedCoin generatedCoin);

    public void delete(GeneratedCoin generatedCoin);

    public GeneratedCoin findGeneratedCoinByCoinUUID(UUID coinUUID);

    public List<GeneratedCoin> findGeneratedCoinsByCurrentEventID(int currentEventID);

    public List<GeneratedCoin> findGeneratedCoinsByCoinType(int coinType);

}
