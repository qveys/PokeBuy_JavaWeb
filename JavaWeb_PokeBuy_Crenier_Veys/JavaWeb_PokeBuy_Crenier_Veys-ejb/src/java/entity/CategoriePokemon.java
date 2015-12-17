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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quentinveys
 */
@Entity
@Table(name = "CATEGORIE_POKEMON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriePokemon.findAll", query = "SELECT c FROM CategoriePokemon c"),
    @NamedQuery(name = "CategoriePokemon.findByIdcategorie", query = "SELECT c FROM CategoriePokemon c WHERE c.idcategorie = :idcategorie")})
public class CategoriePokemon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCATEGORIE")
    private Integer idcategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriePokemon")
    private Collection<CategorieLangue> categorieLangueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategorie")
    private Collection<Pokemon> pokemonCollection;

    public CategoriePokemon() {
    }

    public CategoriePokemon(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    @XmlTransient
    public Collection<CategorieLangue> getCategorieLangueCollection() {
        return categorieLangueCollection;
    }

    public void setCategorieLangueCollection(Collection<CategorieLangue> categorieLangueCollection) {
        this.categorieLangueCollection = categorieLangueCollection;
    }

    @XmlTransient
    public Collection<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void setPokemonCollection(Collection<Pokemon> pokemonCollection) {
        this.pokemonCollection = pokemonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorie != null ? idcategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriePokemon)) {
            return false;
        }
        CategoriePokemon other = (CategoriePokemon) object;
        if ((this.idcategorie == null && other.idcategorie != null) || (this.idcategorie != null && !this.idcategorie.equals(other.idcategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CategoriePokemon[ idcategorie=" + idcategorie + " ]";
    }
    
}
