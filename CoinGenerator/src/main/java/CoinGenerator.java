import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CoinGenerator {

    private static final Logger logger = Logger.getLogger(CoinGenerator.class);

    private final double standardCoinProbability;
    private final double characterCoinProbability;
    private final double characterCoinProbabilityWangnima;
    private final double characterCoinProbabilityZhijin;
    private final double characterCoinProbabilityMuzi;
    private final double characterCoinProbabilityPino;
    private final double characterCoinProbabilityZhangquandan;
    private final double characterCoinProbabilityDaduizhang;
    private final double characterCoinProbabilityZhaotiezhu;
    private final double characterCoinProbabilityLuofugui;

    public CoinGenerator(@Value("#{new Double('${standardCoinProbability}')}") double standardCoinProbability,
                         @Value("#{new Double('${characterCoinProbability}')}") double characterCoinProbability,
                         @Value("#{new Double('${characterCoinProbability.wangnima}')}") double characterCoinProbabilityWangnima,
                         @Value("#{new Double('${characterCoinProbability.zhijin}')}") double characterCoinProbabilityZhijin,
                         @Value("#{new Double('${characterCoinProbability.muzi}')}") double characterCoinProbabilityMuzi,
                         @Value("#{new Double('${characterCoinProbability.pino}')}") double characterCoinProbabilityPino,
                         @Value("#{new Double('${characterCoinProbability.zhangquandan}')}") double characterCoinProbabilityZhangquandan,
                         @Value("#{new Double('${characterCoinProbability.daduizhang}')}") double characterCoinProbabilityDaduizhang,
                         @Value("#{new Double('${characterCoinProbability.zhaotiezhu}')}") double characterCoinProbabilityZhaotiezhu,
                         @Value("#{new Double('${characterCoinProbability.luofugui}')}") double characterCoinProbabilityLuofugui) {
        this.standardCoinProbability = standardCoinProbability;
        this.characterCoinProbability = characterCoinProbability;
        this.characterCoinProbabilityWangnima = characterCoinProbabilityWangnima;
        this.characterCoinProbabilityZhijin = characterCoinProbabilityZhijin;
        this.characterCoinProbabilityMuzi = characterCoinProbabilityMuzi;
        this.characterCoinProbabilityPino = characterCoinProbabilityPino;
        this.characterCoinProbabilityZhangquandan = characterCoinProbabilityZhangquandan;
        this.characterCoinProbabilityDaduizhang = characterCoinProbabilityDaduizhang;
        this.characterCoinProbabilityZhaotiezhu = characterCoinProbabilityZhaotiezhu;
        this.characterCoinProbabilityLuofugui = characterCoinProbabilityLuofugui;
    }

    public Coin generateCoin(String clientAccountID, String requestDetails) throws CoinGeneratorException {
        // rolling for either standard or character coin
        double random = Math.random();
        if (random <= standardCoinProbability) {
            return new StandardCoin();
        } else {
            // rolling for individual character
            random = Math.random();
            if (random < characterCoinProbabilityWangnima) {
                return new CharacterCoin(CharacterCoin.Character.WANGNIMA);
            } else if (characterCoinProbabilityWangnima <= random && random < characterCoinProbabilityZhijin) {
                return new CharacterCoin(CharacterCoin.Character.ZHIJIN);
            } else if (characterCoinProbabilityZhijin <= random && random < characterCoinProbabilityMuzi) {
                return new CharacterCoin(CharacterCoin.Character.MUZI);
            } else if (characterCoinProbabilityMuzi <= random && random < characterCoinProbabilityPino) {
                return new CharacterCoin(CharacterCoin.Character.PINO);
            } else if (characterCoinProbabilityPino <= random && random < characterCoinProbabilityZhangquandan) {
                return new CharacterCoin(CharacterCoin.Character.ZHANGQUANDAN);
            } else if (characterCoinProbabilityZhangquandan <= random && random < characterCoinProbabilityDaduizhang) {
                return new CharacterCoin(CharacterCoin.Character.DADUIZHANG);
            } else if (characterCoinProbabilityDaduizhang <= random && random < characterCoinProbabilityZhaotiezhu) {
                return new CharacterCoin(CharacterCoin.Character.ZHAOTIEZHU);
            } else if (characterCoinProbabilityZhaotiezhu <= random && random < characterCoinProbabilityLuofugui) {
                return new CharacterCoin(CharacterCoin.Character.LUOFUGUI);
            }
        }
        String errorMsg = "No coin has been generated, please check probabilities";
        logger.error(errorMsg);
        throw new CoinGeneratorException(errorMsg);
    }
}
