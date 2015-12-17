
package facade;

import entity.TalentLangue;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelLangue;
import model.ModelTalent;
import model.ModelTalentLangue;

@Stateless
public class TalentLangueFacade extends AbstractFacade<TalentLangue> implements TalentLangueFacadeLocal {
    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TalentLangueFacade() {
        super(TalentLangue.class);
    }

    @Override
    public HashMap<Integer, ModelTalentLangue> getListTalentByLangue(int idLangue) {
        Query query;
        query = em.createNamedQuery("TalentLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);

        List<TalentLangue> result = query.getResultList();

        return createModelTalentLangue(result);
    }

    private HashMap<Integer, ModelTalentLangue> createModelTalentLangue(List<TalentLangue> result) {
        HashMap<Integer, ModelTalentLangue> listType = new HashMap<>();

        for (TalentLangue l : result) {
            ModelTalentLangue newTypeLangue = convertToModelTalentLangue(l);
            listType.put(l.getTalentPokemon().getIdtalent(), newTypeLangue);
        }

        return listType;
    }

    private ModelTalentLangue convertToModelTalentLangue(TalentLangue talentLangue) {
        ModelTalent newTalent = new ModelTalent(talentLangue.getTalentPokemon().getIdtalent());
        ModelLangue newLangue = new ModelLangue(talentLangue.getLangue().getIdlangue(), talentLangue.getLangue().getCodelangue(), talentLangue.getLangue().getLibellelangue());
        return new ModelTalentLangue(newTalent, newLangue, talentLangue.getLibelletalent(), talentLangue.getDescriptiontalent());
    }

}
