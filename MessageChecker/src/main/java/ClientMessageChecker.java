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
            String errorMsg = "Client message incomplete: " + clientMessage + " Correct format is: 'clientAccountID'|'requestType'|'requestDetails'";
            logger.error(errorMsg);
            throw new ClientMessageException(errorMsg);
        }

        logger.debug("Checking client message clientAccountID");
        try{
            Integer.parseInt(clientMessageArray[0]);
        } catch (NumberFormatException e) {
            String errorMsg = "Invalid client account ID";
            logger.error(errorMsg);
            throw new ClientMessageException(errorMsg);
        }

        logger.debug("Checking client message requestType");
        EnumSet<ClientMessage.RequestType> availableRequestTypes = EnumSet.of(ClientMessage.RequestType.GENERATE_COIN);
        try {
            availableRequestTypes.contains(ClientMessage.RequestType.valueOf(clientMessageArray[1]));
        } catch (IllegalArgumentException e) {
            String errorMsg = "Invalid request type";
            logger.error(errorMsg);
            throw new ClientMessageException(errorMsg);
        }

        logger.debug("Checking client message requestDetails");
        //TODO

        return new ClientMessage(clientMessageArray[0], ClientMessage.RequestType.valueOf(clientMessageArray[1]), clientMessageArray[2]);
    }
}


