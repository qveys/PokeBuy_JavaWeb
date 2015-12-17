package facade;

import entity.Client;
import entity.Localite;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelClient;
import model.ModelLocalite;

@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public ModelClient getClientByEmail(String email, String mdpCrypt) {
        Query query;
        query = getEntityManager().createNamedQuery("Client.findByEmail");
        query.setParameter("email", email);

        try {
            Client result = (Client) query.getSingleResult();
            
            try {
                query = getEntityManager().createNamedQuery("Client.findByEmailAndMotdepasse");
                query.setParameter("motdepasse", mdpCrypt);
                query.setParameter("email", email);
                result = (Client) query.getSingleResult();
                ModelLocalite newLocalite = new ModelLocalite(result.getLocalite().getLocalitePK().getCodepostal(), result.getLocalite().getLocalitePK().getVille());
                return new ModelClient(result.getNumclient(), result.getNomclient(), result.getPrenomclient(), result.getAdrNomrue(), newLocalite, result.getNumtel(), result.getEmail(), result.getMotdepasse(), result.getPublicité(), result.getLanguepardefaut());
            } catch (Exception e) {
                return new ModelClient(email);
            }
        } catch (Exception e) {
            return new ModelClient();
        }
    }

    @Override
    public boolean isOneClientByEmail(String email) {
        Query query;
        query = getEntityManager().createNamedQuery("Client.findByEmail");
        query.setParameter("email", email);

        try {
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void setNewClient(ModelClient newClient) {
        Client client = new Client();
        Localite newLocalite = new Localite(newClient.getLocalite().getCodePostal(), newClient.getLocalite().getVille());

        client.setLocalite(newLocalite);
        client.setAdrNomrue(newClient.getAdrNomRue().toUpperCase());
        client.setEmail(newClient.getEmail().toUpperCase());
        client.setMotdepasse(newClient.getMotDePasse());
        client.setNomclient(newClient.getNomClient().toUpperCase());
        client.setPrenomclient(newClient.getPrenomClient().toUpperCase());
        client.setNumtel(newClient.getNumTel());
        client.setPublicité(newClient.isPublicite());
        client.setLanguepardefaut(newClient.getLangueParDefaut());

        getEntityManager().persist(client);
    }

}
