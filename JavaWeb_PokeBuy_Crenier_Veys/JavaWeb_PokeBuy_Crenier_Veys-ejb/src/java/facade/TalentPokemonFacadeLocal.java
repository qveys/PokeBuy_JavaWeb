/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.TalentPokemon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author quentinveys
 */
@Local
public interface TalentPokemonFacadeLocal {

    void create(TalentPokemon talentPokemon);

    void edit(TalentPokemon talentPokemon);

    void remove(TalentPokemon talentPokemon);

    TalentPokemon find(Object id);

    List<TalentPokemon> findAll();

    List<TalentPokemon> findRange(int[] range);

    int count();
    
}
