
package controller;

import business.PokemonSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.ModelTalentLangue;

@Named(value = "talentController")
@SessionScoped
public class TalentController implements Serializable {
    @EJB
    private PokemonSessionBeanLocal pokemonSessionBean;
    
    private HashMap<Integer, ModelTalentLangue> listTalent = new HashMap<>();
    private Locale currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public TalentController() {
    }

    public PokemonSessionBeanLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public void setPokemonSessionBean(PokemonSessionBeanLocal pokemonSessionBean) {
        this.pokemonSessionBean = pokemonSessionBean;
    }
    
    public HashMap<Integer, ModelTalentLangue> getListTalentByLangue() {
        if (listTalent.isEmpty() || currentLanguageList != FacesContext.getCurrentInstance().getViewRoot().getLocale()) {
            currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            listTalent = getPokemonSessionBean().getListTalentByLangue(currentLanguageList);
        }

        return listTalent;
    }
    
    public ModelTalentLangue getOneTalentByLangue(int idTalent) {
        return getListTalentByLangue().get(idTalent);
    }
    
}
