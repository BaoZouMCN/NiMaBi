import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {

    private static final Logger logger = Logger.getLogger(ClientThread.class);
    private final Socket clientSocket;

    @Autowired
    private CoinGenerator coinGenerator;

    @Autowired
    private ClientMessageChecker clientMessageChecker;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
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
                        Coin coin = coinGenerator.generateCoin(clientMessage.getClientAccountID(), clientMessage.getRequestDetails());
                        //TODO register generated coin in database against client's account
                        //TODO return generated coin to client
                        break;
                    default:
                        logger.error("Unable to recognize request type from client with clientAccountID=" + clientMessage.getClientAccountID() + " and requestType=" + clientMessage.getRequestType());
                }

            }
            clientSocket.close();
        } catch (ClientMessageException e) {
            logger.error("Invalid client message", e);
        } catch (IOException e) {
            logger.error("Error closing client connection", e);
        }
    }


}
