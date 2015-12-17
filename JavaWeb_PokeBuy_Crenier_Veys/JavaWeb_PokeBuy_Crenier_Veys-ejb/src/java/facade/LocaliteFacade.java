
package facade;

import entity.Localite;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelLocalite;

@Stateless
public class LocaliteFacade extends AbstractFacade<Localite> implements LocaliteFacadeLocal {
    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocaliteFacade() {
        super(Localite.class);
    }

    @Override
    public ArrayList<ModelLocalite> getLocalitesByPostCode(int postCode) {
        Query query;
        query = getEntityManager().createNamedQuery("Localite.findByCodepostal");
        query.setParameter("codepostal", postCode);
        
        List<Localite> result = query.getResultList();
        
        return createModelLocalite(result);
    }

    private ArrayList<ModelLocalite> createModelLocalite(List<Localite> result) {
        ArrayList<ModelLocalite> listModelLocalite = new ArrayList<>();
        for (Localite r : result) {
            ModelLocalite newModelLocalite = new ModelLocalite(r.getLocalitePK().getCodepostal(), r.getLocalitePK().getVille());
            listModelLocalite.add(newModelLocalite);
        }
        return listModelLocalite;
    }
    
}
