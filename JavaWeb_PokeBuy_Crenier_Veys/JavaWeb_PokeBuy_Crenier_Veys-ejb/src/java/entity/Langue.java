/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "LANGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langue.findAll", query = "SELECT l FROM Langue l"),
    @NamedQuery(name = "Langue.findByIdlangue", query = "SELECT l FROM Langue l WHERE l.idlangue = :idlangue"),
    @NamedQuery(name = "Langue.findByCodelangue", query = "SELECT l FROM Langue l WHERE l.codelangue = :codelangue"),
    @NamedQuery(name = "Langue.findByLibellelangue", query = "SELECT l FROM Langue l WHERE l.libellelangue = :libellelangue")})
public class Langue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLANGUE")
    private Integer idlangue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODELANGUE")
    private String codelangue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LIBELLELANGUE")
    private String libellelangue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "langue")
    private Collection<CategorieLangue> categorieLangueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "langue")
    private Collection<TalentLangue> talentLangueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "langue")
    private Collection<TypeLangue> typeLangueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "langue")
    private Collection<PokemonLangue> pokemonLangueCollection;

    public Langue() {
    }

    public Langue(Integer idlangue) {
        this.idlangue = idlangue;
    }

    public Langue(Integer idlangue, String codelangue, String libellelangue) {
        this.idlangue = idlangue;
        this.codelangue = codelangue;
        this.libellelangue = libellelangue;
    }

    public Integer getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Integer idlangue) {
        this.idlangue = idlangue;
    }

    public String getCodelangue() {
        return codelangue;
    }

    public void setCodelangue(String codelangue) {
        this.codelangue = codelangue;
    }

    public String getLibellelangue() {
        return libellelangue;
    }

    public void setLibellelangue(String libellelangue) {
        this.libellelangue = libellelangue;
    }

    @XmlTransient
    public Collection<CategorieLangue> getCategorieLangueCollection() {
        return categorieLangueCollection;
    }

    public void setCategorieLangueCollection(Collection<CategorieLangue> categorieLangueCollection) {
        this.categorieLangueCollection = categorieLangueCollection;
    }

    @XmlTransient
    public Collection<TalentLangue> getTalentLangueCollection() {
        return talentLangueCollection;
    }

    public void setTalentLangueCollection(Collection<TalentLangue> talentLangueCollection) {
        this.talentLangueCollection = talentLangueCollection;
    }

    @XmlTransient
    public Collection<TypeLangue> getTypeLangueCollection() {
        return typeLangueCollection;
    }

    public void setTypeLangueCollection(Collection<TypeLangue> typeLangueCollection) {
        this.typeLangueCollection = typeLangueCollection;
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
        hash += (idlangue != null ? idlangue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Langue)) {
            return false;
        }
        Langue other = (Langue) object;
        if ((this.idlangue == null && other.idlangue != null) || (this.idlangue != null && !this.idlangue.equals(other.idlangue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Langue[ idlangue=" + idlangue + " ]";
    }
    
}
