import BusinessObject.CoinDefinitionBO;
import Model.GeneratedCoin;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
    private final CoinDefinitionBO coinDefinitionBO;

    public CoinGenerator(@Value("#{new Double('${standardCoinProbability}')}") double standardCoinProbability,
                         @Value("#{new Double('${characterCoinProbability}')}") double characterCoinProbability,
                         @Value("#{new Double('${characterCoinProbability.wangnima}')}") double characterCoinProbabilityWangnima,
                         @Value("#{new Double('${characterCoinProbability.zhijin}')}") double characterCoinProbabilityZhijin,
                         @Value("#{new Double('${characterCoinProbability.muzi}')}") double characterCoinProbabilityMuzi,
                         @Value("#{new Double('${characterCoinProbability.pino}')}") double characterCoinProbabilityPino,
                         @Value("#{new Double('${characterCoinProbability.zhangquandan}')}") double characterCoinProbabilityZhangquandan,
                         @Value("#{new Double('${characterCoinProbability.daduizhang}')}") double characterCoinProbabilityDaduizhang,
                         @Value("#{new Double('${characterCoinProbability.zhaotiezhu}')}") double characterCoinProbabilityZhaotiezhu,
                         @Value("#{new Double('${characterCoinProbability.luofugui}')}") double characterCoinProbabilityLuofugui,
                         CoinDefinitionBO coinDefinitionBO
    ) {
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
        this.coinDefinitionBO = coinDefinitionBO;
    }

    public GeneratedCoin generateCoin(String clientAccountID, String requestDetails) throws CoinGeneratorException {
        // TODO currently all generated coins are hardcoded to event 'NONE' with event_definition_id = 1, they should be coming from request details
        // rolling for either standard or character coin
        double random = Math.random();
        if (random <= standardCoinProbability) {
            return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.NONE.name()).get(0).getCoin_definition_id());
        } else {
            // rolling for individual character
            random = Math.random();
            if (random < characterCoinProbabilityWangnima) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.WANGNIMA.name()).get(0).getCoin_definition_id());
            } else if (characterCoinProbabilityWangnima <= random && random < characterCoinProbabilityZhijin) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.ZHIJIN.name()).get(0).getCoin_definition_id());
            } else if (characterCoinProbabilityZhijin <= random && random < characterCoinProbabilityMuzi) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.MUZI.name()).get(0).getCoin_definition_id());
            } else if (characterCoinProbabilityMuzi <= random && random < characterCoinProbabilityPino) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.PINO.name()).get(0).getCoin_definition_id());
            } else if (characterCoinProbabilityPino <= random && random < characterCoinProbabilityZhangquandan) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.ZHANGQUANDAN.name()).get(0).getCoin_definition_id());
            } else if (characterCoinProbabilityZhangquandan <= random && random < characterCoinProbabilityDaduizhang) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.DADUIZHANG.name()).get(0).getCoin_definition_id());
            } else if (characterCoinProbabilityDaduizhang <= random && random < characterCoinProbabilityZhaotiezhu) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.ZHAOTIEZHU.name()).get(0).getCoin_definition_id());
            } else if (characterCoinProbabilityZhaotiezhu <= random && random < characterCoinProbabilityLuofugui) {
                return new GeneratedCoin(UUID.randomUUID(), coinDefinitionBO.findCoinsByDescription(Character.LUOFUGUI.name()).get(0).getCoin_definition_id());
            }
        }
        String errorMsg = "No coin has been generated, please check probabilities";
        logger.error(errorMsg);
        throw new CoinGeneratorException(errorMsg);
    }

    public enum Character {
        NONE,
        WANGNIMA,
        ZHIJIN,
        MUZI,
        PINO,
        ZHANGQUANDAN,
        DADUIZHANG,
        ZHAOTIEZHU,
        LUOFUGUI
    }
}
