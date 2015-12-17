
package facade;

import entity.Client;
import java.util.List;
import javax.ejb.Local;
import model.ModelClient;

@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();

    ModelClient getClientByEmail(String email, String mdpCrypt);

    boolean isOneClientByEmail(String email);

    void setNewClient(ModelClient newClient);
    
}
