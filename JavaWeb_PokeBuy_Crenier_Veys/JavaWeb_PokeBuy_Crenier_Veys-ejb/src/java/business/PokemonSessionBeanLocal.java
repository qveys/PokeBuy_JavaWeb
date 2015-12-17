
package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.ejb.Local;
import model.ModelCategorieLangue;
import model.ModelClient;
import model.ModelCommande;
import model.ModelLigneCommande;
import model.ModelLocalite;
import model.ModelPokemonLangue;
import model.ModelTalentLangue;
import model.ModelTypeLangue;

@Local
public interface PokemonSessionBeanLocal {

    HashMap<Integer, ModelTypeLangue> getListTypeByLangue(Locale locale);

    HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue(Locale locale);

    HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue(Locale locale);

    HashMap<Integer, ModelTalentLangue> getListTalentByLangue(Locale locale);

    ArrayList<ModelLocalite> getLocalitesByPostCode(int postCode);

    void setNewClient(ModelClient newClient);

    boolean isOneClientByEmail(String email);

    ModelClient getClientByEmail(String email, String mdpCrypt);

    void enregistrerCommande(ModelCommande commande);

    void enregistrerLignes(HashMap<Integer, ModelLigneCommande> hashMapPanier);
    
}
