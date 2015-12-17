
package model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ModelPokemon {
    private Integer idPokemon;
    private String cheminImg;
    private BigDecimal taille;
    private BigDecimal poids;
    private Short pointsVie;
    private Short pointsAttaque;
    private Short pointsDefense;
    private Short pointsAttaqueSpeciale;
    private Short pointsDefenseSpeciale;
    private Short pointsVitesse;
    private BigDecimal prix;
    private ModelCategorie categorie;
    private ArrayList<ModelType> types;
    private ArrayList<ModelType> faiblesses;
    private ArrayList<ModelTalent> talents;

    public ModelPokemon(Integer idPokemon, String cheminImg, BigDecimal taille, BigDecimal poids, Short pointsVie, Short pointsAttaque, Short pointsDefense, Short pointsAttaqueSpeciale, Short pointsDefenseSpeciale, Short pointsVitesse, BigDecimal prix, ModelCategorie categorie, ArrayList<ModelType> types, ArrayList<ModelType> faiblesses, ArrayList<ModelTalent> talents) {
        this.idPokemon = idPokemon;
        this.cheminImg = cheminImg;
        this.taille = taille;
        this.poids = poids;
        this.pointsVie = pointsVie;
        this.pointsAttaque = pointsAttaque;
        this.pointsDefense = pointsDefense;
        this.pointsAttaqueSpeciale = pointsAttaqueSpeciale;
        this.pointsDefenseSpeciale = pointsDefenseSpeciale;
        this.pointsVitesse = pointsVitesse;
        this.prix = prix;
        this.categorie = categorie;
        this.types = types;
        this.faiblesses = faiblesses;
        this.talents = talents;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getCheminImg() {
        return cheminImg;
    }

    public void setCheminImg(String cheminImg) {
        this.cheminImg = cheminImg;
    }

    public BigDecimal getTaille() {
        return taille;
    }

    public void setTaille(BigDecimal taille) {
        this.taille = taille;
    }

    public BigDecimal getPoids() {
        return poids;
    }

    public void setPoids(BigDecimal poids) {
        this.poids = poids;
    }

    public Short getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(Short pointsVie) {
        this.pointsVie = pointsVie;
    }

    public Short getPointsAttaque() {
        return pointsAttaque;
    }

    public void setPointsAttaque(Short pointsAttaque) {
        this.pointsAttaque = pointsAttaque;
    }

    public Short getPointsDefense() {
        return pointsDefense;
    }

    public void setPointsDefense(Short pointsDefense) {
        this.pointsDefense = pointsDefense;
    }

    public Short getPointsAttaqueSpeciale() {
        return pointsAttaqueSpeciale;
    }

    public void setPointsAttaqueSpeciale(Short pointsAttaqueSpeciale) {
        this.pointsAttaqueSpeciale = pointsAttaqueSpeciale;
    }

    public Short getPointsDefenseSpeciale() {
        return pointsDefenseSpeciale;
    }

    public void setPointsDefenseSpeciale(Short pointsDefenseSpeciale) {
        this.pointsDefenseSpeciale = pointsDefenseSpeciale;
    }

    public Short getPointsVitesse() {
        return pointsVitesse;
    }

    public void setPointsVitesse(Short pointsVitesse) {
        this.pointsVitesse = pointsVitesse;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public ModelCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ModelCategorie categorie) {
        this.categorie = categorie;
    }

    public ArrayList<ModelType> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<ModelType> types) {
        this.types = types;
    }

    public ArrayList<ModelType> getFaiblesses() {
        return faiblesses;
    }

    public void setFaiblesses(ArrayList<ModelType> faiblesses) {
        this.faiblesses = faiblesses;
    }

    public ArrayList<ModelTalent> getTalents() {
        return talents;
    }

    public void setTalents(ArrayList<ModelTalent> talents) {
        this.talents = talents;
    }
    
    public String getFullIdPokemon() {
        return ((idPokemon < 100) ? ((idPokemon < 10) ? "00" + idPokemon : "0" + idPokemon) : idPokemon.toString());
    }
    
    public String getCheminImgDetails() {
        int length = cheminImg.length();
        String chemin = cheminImg.substring(0, length - 7);
        String img = cheminImg.substring(length - 7, length);
        return chemin + "details/" + img;
    }
    
}
