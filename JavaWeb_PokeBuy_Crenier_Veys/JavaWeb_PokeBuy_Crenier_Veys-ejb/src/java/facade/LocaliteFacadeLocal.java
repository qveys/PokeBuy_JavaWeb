/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Localite;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import model.ModelLocalite;

/**
 *
 * @author quentinveys
 */
@Local
public interface LocaliteFacadeLocal {

    void create(Localite localite);

    void edit(Localite localite);

    void remove(Localite localite);

    Localite find(Object id);

    List<Localite> findAll();

    List<Localite> findRange(int[] range);

    int count();

    ArrayList<ModelLocalite> getLocalitesByPostCode(int postCode);
    
}
