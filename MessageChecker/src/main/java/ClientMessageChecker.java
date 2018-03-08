import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

@Component
public class ClientMessageChecker {

    private static final Logger logger = Logger.getLogger(ClientMessageChecker.class);

    public ClientMessage checkClientMessage(String clientMessage) throws ClientMessageException {
        logger.debug("About to check client message: " + clientMessage);
        String[] clientMessageArray = clientMessage.split("|");

        logger.debug("Checking client message format");
        if (clientMessageArray.length != 3) {
            throw new ClientMessageException("Client message incomplete: " + clientMessage + " Correct format is: 'clientAccountID'|'requestType'|'requestDetails'");
        }

        logger.debug("Checking client message clientAccountID");
        if (clientMessageArray[0].length() != 36) {
            throw new ClientMessageException("Invalid client account ID length");
        }

        logger.debug("Checking client message requestType");
        EnumSet<ClientMessage.RequestType> availableRequestTypes = EnumSet.of(ClientMessage.RequestType.GENERATE_COIN);
        try {
            availableRequestTypes.contains(ClientMessage.RequestType.valueOf(clientMessageArray[1]));
        } catch (IllegalArgumentException e) {
            throw new ClientMessageException("Invalid request type");
        }

        logger.debug("Checking client message requestDetails");
        //TODO

        return new ClientMessage(clientMessageArray[0], ClientMessage.RequestType.valueOf(clientMessageArray[1]), clientMessageArray[2]);
    }
}


