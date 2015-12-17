
package facade;

import entity.CategorieLangue;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelCategorie;
import model.ModelCategorieLangue;
import model.ModelLangue;

@Stateless
public class CategorieLangueFacade extends AbstractFacade<CategorieLangue> implements CategorieLangueFacadeLocal {
    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieLangueFacade() {
        super(CategorieLangue.class);
    }

    @Override
    public HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue(int idLangue) {
        Query query;
        query = em.createNamedQuery("CategorieLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);

        List<CategorieLangue> result = query.getResultList();

        return createModelCategorieLangue(result);
    }

    private HashMap<Integer, ModelCategorieLangue> createModelCategorieLangue(List<CategorieLangue> result) {
        HashMap<Integer, ModelCategorieLangue> listCategorie = new HashMap<>();

        for (CategorieLangue l : result) {
            ModelCategorieLangue newCategorieLangue = convertToModelCategorieLangue(l);
            listCategorie.put(l.getCategoriePokemon().getIdcategorie(), newCategorieLangue);
        }

        return listCategorie;
    }

    private ModelCategorieLangue convertToModelCategorieLangue(CategorieLangue categorie) {
        ModelLangue newLangue = new ModelLangue(categorie.getLangue().getIdlangue(), categorie.getLangue().getCodelangue(), categorie.getLangue().getLibellelangue());
        ModelCategorie newCategorie = new ModelCategorie(categorie.getCategoriePokemon().getIdcategorie());
        return new ModelCategorieLangue(newCategorie, newLangue, categorie.getLibellecategorie());  
    }
    
    
}
