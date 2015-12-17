
package facade;

import entity.TypeLangue;
import entity.TypePokemon;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelLangue;
import model.ModelPromo;
import model.ModelType;
import model.ModelTypeLangue;

@Stateless
public class TypeLangueFacade extends AbstractFacade<TypeLangue> implements TypeLangueFacadeLocal {
    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeLangueFacade() {
        super(TypeLangue.class);
    }

    @Override
    public HashMap<Integer, ModelTypeLangue> getListTypeByLangue(int idLangue) {
        Query query;
        query = getEntityManager().createNamedQuery("TypeLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);

        List<TypeLangue> result = query.getResultList();

        return createModelTypeLangue(result);
    }

    private HashMap<Integer, ModelTypeLangue> createModelTypeLangue(List<TypeLangue> result) {
        HashMap<Integer, ModelTypeLangue> listType = new HashMap<>();

        for (TypeLangue l : result) {
            ModelTypeLangue newTypeLangue = convertToModelTypeLangue(l);
            listType.put(l.getTypePokemon().getIdtype(), newTypeLangue);
        }
        
        return listType;
    }

    private ModelTypeLangue convertToModelTypeLangue(TypeLangue typeLangue) {
        ModelType newType = convertToModelType(typeLangue.getTypePokemon());
        ModelLangue newLangue = new ModelLangue(typeLangue.getLangue().getIdlangue(), typeLangue.getLangue().getCodelangue(), typeLangue.getLangue().getLibellelangue());
        return new ModelTypeLangue(newType, newLangue, typeLangue.getLibelletype());   
    }

    private ModelType convertToModelType(TypePokemon typePokemon) {
        ModelPromo newPromo;
        try {
            newPromo = new ModelPromo(typePokemon.getCodepromotion().getCodepromo(), typePokemon.getCodepromotion().getPourcentagepromo().doubleValue());
        } catch (NullPointerException e) {
            newPromo = null;
        }
        return new ModelType(typePokemon.getIdtype(), newPromo);
    }
    
}
