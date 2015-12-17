/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TypePokemon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author quentinveys
 */
@Local
public interface TypePokemonFacadeLocal {

    void create(TypePokemon typePokemon);

    void edit(TypePokemon typePokemon);

    void remove(TypePokemon typePokemon);

    TypePokemon find(Object id);

    List<TypePokemon> findAll();

    List<TypePokemon> findRange(int[] range);

    int count();
    
}
