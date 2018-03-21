import BusinessObject.*;
import Model.GeneratedCoin;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {

    private static final Logger logger = Logger.getLogger(ClientThread.class);
    private final Socket clientSocket;
    private final CoinGenerator coinGenerator;
    private final ClientMessageChecker clientMessageChecker;
    private final ClientBO clientBO;
    private final CoinDefinitionBO coinBO;
    private final CoinHistoryBO coinHistoryBO;
    private final EventDefinitionBO eventBO;
    private final GeneratedCoinBO generatedCoinBO;

    @Autowired
    public ClientThread(Socket clientSocket,
                        ClientMessageChecker clientMessageChecker,
                        CoinGenerator coinGenerator,
                        ClientBO clientBO,
                        CoinDefinitionBO coinBO,
                        CoinHistoryBO coinHistoryBO,
                        EventDefinitionBO eventBO,
                        GeneratedCoinBO generatedCoinBO
    ){
        this.clientSocket = clientSocket;
        this.clientMessageChecker = clientMessageChecker;
        this.coinGenerator = coinGenerator;
        this.clientBO = clientBO;
        this.coinBO = coinBO;
        this.coinHistoryBO = coinHistoryBO;
        this.eventBO = eventBO;
        this.generatedCoinBO = generatedCoinBO;
    }

    public void run() {
        logger.debug("Connected to: " + clientSocket.getRemoteSocketAddress());
        String clientString;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while ((clientString = br.readLine()) != null) {
                logger.debug("Message from " + clientSocket.getRemoteSocketAddress() + " is: " + clientString);
                // Checking the validity of the message
                ClientMessage clientMessage = clientMessageChecker.checkClientMessage(clientString);
                switch (clientMessage.getRequestType()) {
                    case GENERATE_COIN:
                        GeneratedCoin generatedCoin = coinGenerator.generateCoin(clientMessage.getClientAccountID(), clientMessage.getRequestDetails());
                        //TODO register generated coin in database against client's account
                        //TODO return generated coin to client
                        break;
                    default:
                        logger.error("Unable to recognise request type from client with clientAccountID=" + clientMessage.getClientAccountID() + " and requestType=" + clientMessage.getRequestType());
                }

            }
            clientSocket.close();
        } catch (ClientMessageException | CoinGeneratorException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error("Error closing client connection", e);
        }
    }


}
