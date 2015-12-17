
package controller;

import business.PokemonSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.ModelPokemonLangue;
import model.ModelType;

@Named(value = "pokemonController")
@SessionScoped
public class PokemonController implements Serializable {
    @EJB
    private PokemonSessionBeanLocal pokemonSessionBean;
    
    private HashMap<Integer, ModelPokemonLangue> hashMapPokemon = new HashMap<>();
    private ModelPokemonLangue currentPokemon = null;
    private Locale currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private int qtePokemon;
    
    Random rand = new Random();

    public PokemonController() {
    }

    public PokemonSessionBeanLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public void setPokemonSessionBean(PokemonSessionBeanLocal pokemonSessionBean) {
        this.pokemonSessionBean = pokemonSessionBean;
    }

    public ModelPokemonLangue getCurrentPokemon() {
        if (currentLanguageList != FacesContext.getCurrentInstance().getViewRoot().getLocale()) {
            hashMapPokemon = getListPokemonByLangue();
            currentPokemon = hashMapPokemon.get(currentPokemon.getPokemon().getIdPokemon());
        }
        return currentPokemon;
    }

    public void setCurrentPokemon(ModelPokemonLangue currentPokemon) {
        this.currentPokemon = currentPokemon;
    }

    public int getQtePokemon() {
        return qtePokemon;
    }

    public void setQtePokemon(int qtePokemon) {
        this.qtePokemon = qtePokemon;
    }

    public void ajoutQtePokemon() {
        qtePokemon += 1;
    }
    
    public void suppQtePokemon() {
        if (qtePokemon != 1)
            qtePokemon -= 1;
    }
    
    public HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue() {
        if (hashMapPokemon.isEmpty() || currentLanguageList != FacesContext.getCurrentInstance().getViewRoot().getLocale()) {
            currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            hashMapPokemon = getPokemonSessionBean().getListPokemonByLangue(currentLanguageList);
        }
        return hashMapPokemon;
    }
    
    public ModelPokemonLangue getOnePokemonByLangue(int idPokemon) {
        return getListPokemonByLangue().get(idPokemon);
    }
    
    public String aleatoirePokemon() {
        qtePokemon = 1;
        int nombreAleatoire = rand.nextInt(hashMapPokemon.size()) + 1;
        currentPokemon = hashMapPokemon.get(nombreAleatoire);
        return "details?faces-redirect=true";
    }
    
    public String details(ModelPokemonLangue pokemon) {
        qtePokemon = 1;
        currentPokemon = pokemon;
        return "details?faces-redirect=true";
    }
    
    public ModelPokemonLangue getPrevious() {
        int i = getCurrentPokemon().getPokemon().getIdPokemon() - 1;
        if (i <= 0) {
            i = getListPokemonByLangue().size();
        }
        return getListPokemonByLangue().get(i);
    }
    
    public ModelPokemonLangue getNext() {
        int i = getCurrentPokemon().getPokemon().getIdPokemon() + 1;
        if (i > getListPokemonByLangue().size()) {
            i = 1;
        }
        return getListPokemonByLangue().get(i);
    }
    
    public String getTypesSorting(ArrayList<ModelType> types) {
        String typesSorting = "";
        for (ModelType type : types) {
            typesSorting += type.getSortingType() + " ";
        }
        return typesSorting;
    }
    
    public int getStatsPourc(int points) {
        return (100 - (points * 10));
    }
    
}
