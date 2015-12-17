/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quentinveys
 */
@Entity
@Table(name = "POKEMON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pokemon.findAll", query = "SELECT p FROM Pokemon p"),
    @NamedQuery(name = "Pokemon.findByIdpokemon", query = "SELECT p FROM Pokemon p WHERE p.idpokemon = :idpokemon"),
    @NamedQuery(name = "Pokemon.findByCheminImg", query = "SELECT p FROM Pokemon p WHERE p.cheminImg = :cheminImg"),
    @NamedQuery(name = "Pokemon.findByTaille", query = "SELECT p FROM Pokemon p WHERE p.taille = :taille"),
    @NamedQuery(name = "Pokemon.findByPoids", query = "SELECT p FROM Pokemon p WHERE p.poids = :poids"),
    @NamedQuery(name = "Pokemon.findByPointsVie", query = "SELECT p FROM Pokemon p WHERE p.pointsVie = :pointsVie"),
    @NamedQuery(name = "Pokemon.findByPointsAttaque", query = "SELECT p FROM Pokemon p WHERE p.pointsAttaque = :pointsAttaque"),
    @NamedQuery(name = "Pokemon.findByPointsDefense", query = "SELECT p FROM Pokemon p WHERE p.pointsDefense = :pointsDefense"),
    @NamedQuery(name = "Pokemon.findByPointsASpeciale", query = "SELECT p FROM Pokemon p WHERE p.pointsASpeciale = :pointsASpeciale"),
    @NamedQuery(name = "Pokemon.findByPointsDSpeciale", query = "SELECT p FROM Pokemon p WHERE p.pointsDSpeciale = :pointsDSpeciale"),
    @NamedQuery(name = "Pokemon.findByPointsVitesse", query = "SELECT p FROM Pokemon p WHERE p.pointsVitesse = :pointsVitesse"),
    @NamedQuery(name = "Pokemon.findByPrix", query = "SELECT p FROM Pokemon p WHERE p.prix = :prix")})
public class Pokemon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPOKEMON")
    private Integer idpokemon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CHEMIN_IMG")
    private String cheminImg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAILLE")
    private BigDecimal taille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POIDS")
    private BigDecimal poids;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTS_VIE")
    private short pointsVie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTS_ATTAQUE")
    private short pointsAttaque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTS_DEFENSE")
    private short pointsDefense;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTS_A_SPECIALE")
    private short pointsASpeciale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTS_D_SPECIALE")
    private short pointsDSpeciale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTS_VITESSE")
    private short pointsVitesse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIX")
    private BigDecimal prix;
    @JoinTable(name = "LIEN_POKEMON_TALENT", joinColumns = {
        @JoinColumn(name = "IDPOKEMON", referencedColumnName = "IDPOKEMON")}, inverseJoinColumns = {
        @JoinColumn(name = "IDTALENT", referencedColumnName = "IDTALENT")})
    @ManyToMany
    private Collection<TalentPokemon> talentPokemonCollection;
    @JoinTable(name = "LIEN_POKEMON_TYPE", joinColumns = {
        @JoinColumn(name = "IDPOKEMON", referencedColumnName = "IDPOKEMON")}, inverseJoinColumns = {
        @JoinColumn(name = "IDTYPE", referencedColumnName = "IDTYPE")})
    @ManyToMany
    private Collection<TypePokemon> typePokemonCollection;
    @JoinTable(name = "LIEN_POKEMON_FAIBLESSE", joinColumns = {
        @JoinColumn(name = "IDPOKEMON", referencedColumnName = "IDPOKEMON")}, inverseJoinColumns = {
        @JoinColumn(name = "IDTYPE", referencedColumnName = "IDTYPE")})
    @ManyToMany
    private Collection<TypePokemon> typePokemonCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpokemon")
    private Collection<Lignecommande> lignecommandeCollection;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "IDCATEGORIE")
    @ManyToOne(optional = false)
    private CategoriePokemon idcategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon")
    private Collection<PokemonLangue> pokemonLangueCollection;

    public Pokemon() {
    }

    public Pokemon(Integer idpokemon) {
        this.idpokemon = idpokemon;
    }

    public Pokemon(Integer idpokemon, String cheminImg, BigDecimal taille, BigDecimal poids, short pointsVie, short pointsAttaque, short pointsDefense, short pointsASpeciale, short pointsDSpeciale, short pointsVitesse, BigDecimal prix) {
        this.idpokemon = idpokemon;
        this.cheminImg = cheminImg;
        this.taille = taille;
        this.poids = poids;
        this.pointsVie = pointsVie;
        this.pointsAttaque = pointsAttaque;
        this.pointsDefense = pointsDefense;
        this.pointsASpeciale = pointsASpeciale;
        this.pointsDSpeciale = pointsDSpeciale;
        this.pointsVitesse = pointsVitesse;
        this.prix = prix;
    }

    public Integer getIdpokemon() {
        return idpokemon;
    }

    public void setIdpokemon(Integer idpokemon) {
        this.idpokemon = idpokemon;
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

    public short getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(short pointsVie) {
        this.pointsVie = pointsVie;
    }

    public short getPointsAttaque() {
        return pointsAttaque;
    }

    public void setPointsAttaque(short pointsAttaque) {
        this.pointsAttaque = pointsAttaque;
    }

    public short getPointsDefense() {
        return pointsDefense;
    }

    public void setPointsDefense(short pointsDefense) {
        this.pointsDefense = pointsDefense;
    }

    public short getPointsASpeciale() {
        return pointsASpeciale;
    }

    public void setPointsASpeciale(short pointsASpeciale) {
        this.pointsASpeciale = pointsASpeciale;
    }

    public short getPointsDSpeciale() {
        return pointsDSpeciale;
    }

    public void setPointsDSpeciale(short pointsDSpeciale) {
        this.pointsDSpeciale = pointsDSpeciale;
    }

    public short getPointsVitesse() {
        return pointsVitesse;
    }

    public void setPointsVitesse(short pointsVitesse) {
        this.pointsVitesse = pointsVitesse;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @XmlTransient
    public Collection<TalentPokemon> getTalentPokemonCollection() {
        return talentPokemonCollection;
    }

    public void setTalentPokemonCollection(Collection<TalentPokemon> talentPokemonCollection) {
        this.talentPokemonCollection = talentPokemonCollection;
    }

    @XmlTransient
    public Collection<TypePokemon> getTypePokemonCollection() {
        return typePokemonCollection;
    }

    public void setTypePokemonCollection(Collection<TypePokemon> typePokemonCollection) {
        this.typePokemonCollection = typePokemonCollection;
    }

    @XmlTransient
    public Collection<TypePokemon> getTypePokemonCollection1() {
        return typePokemonCollection1;
    }

    public void setTypePokemonCollection1(Collection<TypePokemon> typePokemonCollection1) {
        this.typePokemonCollection1 = typePokemonCollection1;
    }

    @XmlTransient
    public Collection<Lignecommande> getLignecommandeCollection() {
        return lignecommandeCollection;
    }

    public void setLignecommandeCollection(Collection<Lignecommande> lignecommandeCollection) {
        this.lignecommandeCollection = lignecommandeCollection;
    }

    public CategoriePokemon getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(CategoriePokemon idcategorie) {
        this.idcategorie = idcategorie;
    }

    @XmlTransient
    public Collection<PokemonLangue> getPokemonLangueCollection() {
        return pokemonLangueCollection;
    }

    public void setPokemonLangueCollection(Collection<PokemonLangue> pokemonLangueCollection) {
        this.pokemonLangueCollection = pokemonLangueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpokemon != null ? idpokemon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pokemon)) {
            return false;
        }
        Pokemon other = (Pokemon) object;
        if ((this.idpokemon == null && other.idpokemon != null) || (this.idpokemon != null && !this.idpokemon.equals(other.idpokemon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pokemon[ idpokemon=" + idpokemon + " ]";
    }
    
}
