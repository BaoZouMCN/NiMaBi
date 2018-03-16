package BusinessObject;

import DAO.ClientDAO;
import Model.Client;

public class ClientBOImpl implements ClientBO {

    private ClientDAO clientDAO;

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void save(Client client) {
        this.clientDAO.save(client);
    }

    public void update(Client client) {
        this.clientDAO.update(client);
    }

    public void delete(Client client) {
        this.clientDAO.delete(client);
    }

    public Client findClientByBaozouID(String baozouID) {
        return this.clientDAO.findClientByBaozouID(baozouID);
    }

    public Client findClientByClientAccountID(int clientAccountID) {
        return this.clientDAO.findClientByClientAccountID(clientAccountID);
    }

}
