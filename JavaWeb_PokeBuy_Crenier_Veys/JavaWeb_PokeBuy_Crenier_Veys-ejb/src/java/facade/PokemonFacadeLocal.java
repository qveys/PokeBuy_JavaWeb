/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pokemon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author quentinveys
 */
@Local
public interface PokemonFacadeLocal {

    void create(Pokemon pokemon);

    void edit(Pokemon pokemon);

    void remove(Pokemon pokemon);

    Pokemon find(Object id);

    List<Pokemon> findAll();

    List<Pokemon> findRange(int[] range);

    int count();
    
}
