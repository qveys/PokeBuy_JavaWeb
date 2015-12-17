package business;

import facade.CategorieLangueFacadeLocal;
import facade.ClientFacadeLocal;
import facade.CommandeFacadeLocal;
import facade.LignecommandeFacadeLocal;
import facade.LocaliteFacadeLocal;
import facade.PokemonLangueFacadeLocal;
import facade.TalentLangueFacadeLocal;
import facade.TypeLangueFacadeLocal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.ModelCategorieLangue;
import model.ModelClient;
import model.ModelCommande;
import model.ModelLigneCommande;
import model.ModelLocalite;
import model.ModelPokemonLangue;
import model.ModelTalentLangue;
import model.ModelTypeLangue;

@Stateless
public class PokemonSessionBean implements PokemonSessionBeanLocal {
    @EJB
    private LignecommandeFacadeLocal lignecommandeFacade;
    @EJB
    private CommandeFacadeLocal commandeFacade;
    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private LocaliteFacadeLocal localiteFacade;
    @EJB
    private TalentLangueFacadeLocal talentLangueFacade;
    @EJB
    private CategorieLangueFacadeLocal categorieLangueFacade;
    @EJB
    private PokemonLangueFacadeLocal pokemonLangueFacade;
    @EJB
    private TypeLangueFacadeLocal typeLangueFacade;

    @Override
    public HashMap<Integer, ModelTypeLangue> getListTypeByLangue(Locale locale) {
        int idLangue = convertLocaleToInt(locale);
        return typeLangueFacade.getListTypeByLangue(idLangue);
    }

    private int convertLocaleToInt(Locale locale) {
        switch (locale.toString()) {
            case "fr":
                return 1;
            case "en":
                return 2;
            default:
                return 3;
        }
    }

    @Override
    public HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue(Locale locale) {
        int idLangue = convertLocaleToInt(locale);
        return pokemonLangueFacade.getListPokemonByLangue(idLangue);
    }

    @Override
    public HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue(Locale locale) {
        int idLangue = convertLocaleToInt(locale);
        return categorieLangueFacade.getListCategorieByLangue(idLangue);
    }

    @Override
    public HashMap<Integer, ModelTalentLangue> getListTalentByLangue(Locale locale) {
        int idLangue = convertLocaleToInt(locale);
        return talentLangueFacade.getListTalentByLangue(idLangue);
    }

    @Override
    public ArrayList<ModelLocalite> getLocalitesByPostCode(int postCode) {
        return localiteFacade.getLocalitesByPostCode(postCode);
    }

    @Override
    public void setNewClient(ModelClient newClient) {
        clientFacade.setNewClient(newClient);
    }

    @Override
    public boolean isOneClientByEmail(String email) {
        return clientFacade.isOneClientByEmail(email);
    }

    @Override
    public ModelClient getClientByEmail(String email, String mdpCrypt) {
        return clientFacade.getClientByEmail(email, mdpCrypt);
    }

    @Override
    public void enregistrerCommande(ModelCommande commande) {
        commandeFacade.enregistrerCommande(commande);
    }

    @Override
    public void enregistrerLignes(HashMap<Integer, ModelLigneCommande> hashMapPanier) {
        lignecommandeFacade.enregistrerLignes(hashMapPanier);
    }
    
    

}
