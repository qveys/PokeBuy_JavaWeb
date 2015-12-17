
package model;

public class ModelLigneCommande {
    private ModelCommande commande;
    private int numLigne;
    private ModelPokemon pokemon;
    private int quantite;
    private double prixUnitaire;

    public ModelLigneCommande(ModelCommande commande, int numLigne, ModelPokemon pokemon, int quantite, double prixUnitaire) {
        this.commande = commande;
        this.numLigne = numLigne;
        this.pokemon = pokemon;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public ModelCommande getCommande() {
        return commande;
    }

    public void setCommande(ModelCommande commande) {
        this.commande = commande;
    }

    public int getNumLigne() {
        return numLigne;
    }

    public void setNumLigne(int numLigne) {
        this.numLigne = numLigne;
    }

    public ModelPokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(ModelPokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
}
