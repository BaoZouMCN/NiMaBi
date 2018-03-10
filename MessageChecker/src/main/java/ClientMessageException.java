public class ClientMessageException extends Exception {

    public ClientMessageException() {
        super();
    }

    public ClientMessageException(String message) {
        super(message);
    }

    public ClientMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientMessageException(Throwable cause) {
        super(cause);
    }
}
