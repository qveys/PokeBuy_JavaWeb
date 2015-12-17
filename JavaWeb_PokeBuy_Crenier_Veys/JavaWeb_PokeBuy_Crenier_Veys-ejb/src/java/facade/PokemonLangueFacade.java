/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pokemon;
import entity.PokemonLangue;
import entity.TalentPokemon;
import entity.TypePokemon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ModelCategorie;
import model.ModelLangue;
import model.ModelPokemon;
import model.ModelPokemonLangue;
import model.ModelPromo;
import model.ModelTalent;
import model.ModelType;

/**
 *
 * @author quentinveys
 */
@Stateless
public class PokemonLangueFacade extends AbstractFacade<PokemonLangue> implements PokemonLangueFacadeLocal {

    @PersistenceContext(unitName = "JavaWeb_PokeBuy_Crenier_Veys-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PokemonLangueFacade() {
        super(PokemonLangue.class);
    }

    @Override
    public HashMap<Integer, ModelPokemonLangue> getListPokemonByLangue(int idLangue) {
        Query query;
        query = getEntityManager().createNamedQuery("PokemonLangue.findByIdlangue");
        query.setParameter("idlangue", idLangue);

        List<PokemonLangue> result = query.getResultList();

        return createModelPokemonLangue(result);
    }

    private HashMap<Integer, ModelPokemonLangue> createModelPokemonLangue(List<PokemonLangue> result) {
        HashMap<Integer, ModelPokemonLangue> hashMapPokemon = new HashMap<>();
        for (PokemonLangue r : result) {
            Pokemon pokemon = r.getPokemon();

            ArrayList<ModelType> listType = getArrayListModelType(pokemon.getTypePokemonCollection());

            ArrayList<ModelType> listFaiblesse = getArrayListModelType(pokemon.getTypePokemonCollection1());

            ArrayList<ModelTalent> listTalent = getArrayListModelTalent(pokemon.getTalentPokemonCollection());

            ModelCategorie newCategorie = new ModelCategorie(pokemon.getIdcategorie().getIdcategorie());
            ModelPokemon newPokemon = new ModelPokemon(pokemon.getIdpokemon(), pokemon.getCheminImg(), pokemon.getTaille(), pokemon.getPoids(), pokemon.getPointsVie(), pokemon.getPointsAttaque(), pokemon.getPointsDefense(), pokemon.getPointsASpeciale(), pokemon.getPointsDSpeciale(), pokemon.getPointsVitesse(), pokemon.getPrix(), newCategorie, listType, listFaiblesse, listTalent);
            ModelLangue newLangue = new ModelLangue(r.getLangue().getIdlangue(), r.getLangue().getCodelangue(), r.getLangue().getLibellelangue());
            ModelPokemonLangue newPokemonLangue = new ModelPokemonLangue(newLangue, newPokemon, r.getLibellepokemon(), r.getDescriptionpokemon());
            hashMapPokemon.put(pokemon.getIdpokemon(), newPokemonLangue);
        }
        return hashMapPokemon;
    }

    private ArrayList<ModelType> getArrayListModelType(Collection<TypePokemon> typePokemonCollection) {
        ArrayList<ModelType> listType = new ArrayList<>();
        for (TypePokemon type : typePokemonCollection) {
            ModelType newType = convertToModelType(type);
            listType.add(newType);
        }
        return listType;
    }

    private ArrayList<ModelTalent> getArrayListModelTalent(Collection<TalentPokemon> talentPokemonCollection) {
        ArrayList<ModelTalent> listTalent = new ArrayList<>();
        for (TalentPokemon talent : talentPokemonCollection) {
            ModelTalent newTalent = convertToModelTalent(talent);
            listTalent.add(newTalent);
        }
        return listTalent;

    }

    private ModelType convertToModelType(TypePokemon type) {
        ModelPromo newPromo;
        try {
            newPromo = new ModelPromo(type.getCodepromotion().getCodepromo(), type.getCodepromotion().getPourcentagepromo().doubleValue());
        } catch (NullPointerException e) {
            newPromo = null;
        }
        return new ModelType(type.getIdtype(), newPromo);
    }

    private ModelTalent convertToModelTalent(TalentPokemon talent) {
        return new ModelTalent(talent.getIdtalent());
    }

}
