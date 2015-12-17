/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TypeLangue;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.ModelTypeLangue;

/**
 *
 * @author quentinveys
 */
@Local
public interface TypeLangueFacadeLocal {

    void create(TypeLangue typeLangue);

    void edit(TypeLangue typeLangue);

    void remove(TypeLangue typeLangue);

    TypeLangue find(Object id);

    List<TypeLangue> findAll();

    List<TypeLangue> findRange(int[] range);

    int count();

    HashMap<Integer, ModelTypeLangue> getListTypeByLangue(int idLangue);
    
}
