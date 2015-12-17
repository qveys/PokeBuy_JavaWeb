
package model;

public class ModelPokemonLangue {
    private ModelLangue langue;
    private ModelPokemon pokemon;
    private String libellePokemon;
    private String descriptionPokemon;

    public ModelPokemonLangue(ModelLangue langue, ModelPokemon pokemon, String libellePokemon, String descriptionPokemon) {
        this.langue = langue;
        this.pokemon = pokemon;
        this.libellePokemon = libellePokemon;
        this.descriptionPokemon = descriptionPokemon;
    }

    public ModelLangue getLangue() {
        return langue;
    }

    public void setLangue(ModelLangue langue) {
        this.langue = langue;
    }

    public ModelPokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(ModelPokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getLibellePokemon() {
        return libellePokemon;
    }

    public void setLibellePokemon(String libellePokemon) {
        this.libellePokemon = libellePokemon;
    }

    public String getDescriptionPokemon() {
        return descriptionPokemon;
    }

    public void setDescriptionPokemon(String descriptionPokemon) {
        this.descriptionPokemon = descriptionPokemon;
    }
    
}
