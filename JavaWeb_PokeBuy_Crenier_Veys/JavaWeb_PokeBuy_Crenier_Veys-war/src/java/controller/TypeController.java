
package controller;

import business.PokemonSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import model.ModelTypeLangue;

@Named(value = "typeController")
@SessionScoped
public class TypeController implements Serializable {
    @EJB
    private PokemonSessionBeanLocal pokemonSessionBean;
    
    private HashMap<Integer, ModelTypeLangue> listType = new HashMap<>();
    private Locale currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public TypeController() {
    }

    public PokemonSessionBeanLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public void setPokemonSessionBean(PokemonSessionBeanLocal pokemonSessionBean) {
        this.pokemonSessionBean = pokemonSessionBean;
    }
    
    public HashMap<Integer, ModelTypeLangue> getListTypeByLangue() {

        if (listType.isEmpty() || currentLanguageList != FacesContext.getCurrentInstance().getViewRoot().getLocale()) {
            currentLanguageList = FacesContext.getCurrentInstance().getViewRoot().getLocale();
            listType = getPokemonSessionBean().getListTypeByLangue(currentLanguageList);
        }
//        Collections.sort(listType.values(), new Comparator<ModelTypeLangue>() {
//            @Override
//            public int compare(ModelTypeLangue o1, ModelTypeLangue o2) {
//                return o1.getLibelleType().compareTo(o2.getLibelleType());
//            }
//        }
//        );
        return listType;
    }
    
    public ModelTypeLangue getOneTypeByLangue(int idType) {
        return getListTypeByLangue().get(idType);
    }
    
}
