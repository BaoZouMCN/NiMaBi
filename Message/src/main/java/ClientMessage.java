public class ClientMessage {

    private final String clientAccountID;
    private final RequestType requestType;
    private final String requestDetails;

    public ClientMessage(String clientAccountID, RequestType requestType, String requestDetails){
        this.clientAccountID = clientAccountID;
        this.requestType = requestType;
        this.requestDetails = requestDetails;
    }

    public String getClientAccountID(){
        return clientAccountID;
    }

    public RequestType getRequestType(){
        return requestType;
    }

    public String getRequestDetails(){
        return requestDetails;
    }

    public enum RequestType {
        GENERATE_COIN
    }
}
