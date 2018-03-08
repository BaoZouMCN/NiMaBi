import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CoinGenerator {

    @Value("#{new Double('${standardCoinProbability}')}")
    private double standardCoinProbability;
    @Value("#{new Double('${characterCoinProbability}')}")
    private double characterCoinProbability;
    @Value("#{new Double('${characterCoinProbability.wangnima}')}")
    private double characterCoinProbabilityWangnima;
    @Value("#{new Double('${characterCoinProbability.zhijin}')}")
    private double characterCoinProbabilityZhijin;
    @Value("#{new Double('${characterCoinProbability.muzi}')}")
    private double characterCoinProbabilityMuzi;
    @Value("#{new Double('${characterCoinProbability.pino}')}")
    private double characterCoinProbabilityPino;
    @Value("#{new Double('${characterCoinProbability.zhangquandan}')}")
    private double characterCoinProbabilityZhangquandan;
    @Value("#{new Double('${characterCoinProbability.daduizhang}')}")
    private double characterCoinProbabilityDaduizhang;
    @Value("#{new Double('${characterCoinProbability.zhaotiezhu}')}")
    private double characterCoinProbabilityZhaotiezhu;
    @Value("#{new Double('${characterCoinProbability.luofugui}')}")
    private double characterCoinProbabilityLuofugui;

    public CoinGenerator(){

    }

    public Coin generateCoin(String clientAccountID, String requestDetails){


        return null;
    }

}
