/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Langue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author quentinveys
 */
@Local
public interface LangueFacadeLocal {

    void create(Langue langue);

    void edit(Langue langue);

    void remove(Langue langue);

    Langue find(Object id);

    List<Langue> findAll();

    List<Langue> findRange(int[] range);

    int count();
    
}
