package DAO;

import Model.Client;

public interface ClientDAO {

    public void save(Client client);

    public void update(Client client);

    public void delete(Client client);

    public Client findClientByBaozouID(String baozouID);

    public Client findClientByClientAccountID(int clientAccountID);

}
