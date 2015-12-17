
package facade;

import entity.PokemonLangue;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.ModelPokemonLangue;

@Local
public interface PokemonLangueFacadeLocal {

    void create(PokemonLangue pokemonLangue);

    void edit(PokemonLangue pokemonLangue);

    void remove(PokemonLangue pokemonLangue);

    PokemonLangue find(Object id);

    List<PokemonLangue> findAll();

    List<PokemonLangue> findRange(int[] range);

    int count();

    HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue(int idLangue);
    
}
