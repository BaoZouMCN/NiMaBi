import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@ComponentScan
public class NiMaBiServerStarter {

    private static final Logger logger = Logger.getLogger(NiMaBiServerStarter.class);
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ServerConfig.class);
        ctx.refresh();

        ServerConfig serverConfig = ctx.getBean(ServerConfig.class);
        int portNumber = serverConfig.getServerPortNumber();
        int maxClientsAllowed = serverConfig.getMaxClientAllowed();

        ExecutorService clientThreadExecutorService = Executors.newFixedThreadPool(maxClientsAllowed);

        try {
            logger.debug("Starting server on port: " + portNumber);
            serverSocket = new ServerSocket(portNumber);
            while (true) {
                logger.debug("Waiting for request");
                try {
                    Socket socket = serverSocket.accept();
                    logger.debug("Processing request");
                    clientThreadExecutorService.submit(new ClientThread(socket));
                } catch (IOException e) {
                    logger.error("Error accepting connection", e);
                }
            }
        } catch (IOException e) {
            logger.error("Error starting server on port: " + portNumber, e);
            System.exit(0);
        }
    }
}
