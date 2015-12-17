
package facade;

import entity.TalentLangue;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.ModelTalentLangue;

@Local
public interface TalentLangueFacadeLocal {

    void create(TalentLangue talentLangue);

    void edit(TalentLangue talentLangue);

    void remove(TalentLangue talentLangue);

    TalentLangue find(Object id);

    List<TalentLangue> findAll();

    List<TalentLangue> findRange(int[] range);

    int count();

    HashMap<Integer, ModelTalentLangue> getListTalentByLangue(int idLangue);
    
}
