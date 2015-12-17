package facade;

import entity.Client;
import entity.Commande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ModelClient;
import model.ModelCommande;

@Stateless
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {

    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }

    @Override
    public void enregistrerCommande(ModelCommande commande) {
        Commande newCommande = new Commande();
        ModelClient monClient = commande.getClient();
        Client newClient = new Client(monClient.getNumClient(), monClient.getNomClient(), monClient.getPrenomClient(), monClient.getMotDePasse(), monClient.getAdrNomRue(), monClient.getNumTel(), monClient.getEmail());

        newCommande.setDatecommande(commande.getDateCommande());
        newCommande.setDatelivraison(commande.getDateLivraison());
        newCommande.setNumclient(newClient);

        getEntityManager().persist(newCommande);
    }

}
