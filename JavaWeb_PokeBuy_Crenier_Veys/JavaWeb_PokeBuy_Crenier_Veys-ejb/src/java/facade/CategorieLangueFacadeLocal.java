
package facade;

import entity.CategorieLangue;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.ModelCategorieLangue;

@Local
public interface CategorieLangueFacadeLocal {

    void create(CategorieLangue categorieLangue);

    void edit(CategorieLangue categorieLangue);

    void remove(CategorieLangue categorieLangue);

    CategorieLangue find(Object id);

    List<CategorieLangue> findAll();

    List<CategorieLangue> findRange(int[] range);

    int count();

    HashMap<Integer, ModelCategorieLangue> getListCategorieByLangue(int idLangue);
    
}
