
package controller;

import business.PokemonSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.ModelCategorieLangue;

@Named(value = "categorieController")
@SessionScoped
public class CategorieController implements Serializable {
    @EJB
    private PokemonSessionBeanLocal pokemonSessionBean;
    
    private HashMap<Integer, ModelCategorieLangue> listCategorie = new HashMap<>();
    private Locale currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public CategorieController() {
    }

    public PokemonSessionBeanLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public void setPokemonSessionBean(PokemonSessionBeanLocal pokemonSessionBean) {
        this.pokemonSessionBean = pokemonSessionBean;
    }
    
    public HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue() {
        if (listCategorie.isEmpty() || currentLanguageList != FacesContext.getCurrentInstance().getViewRoot().getLocale()) {
            currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            listCategorie = getPokemonSessionBean().getListCategorieByLangue(currentLanguageList);
        }
        return listCategorie;
    }

    public ModelCategorieLangue getOneCategorieByLangue(int idCategorie) {
        return getListCategorieByLangue().get(idCategorie);
    }
    
}
