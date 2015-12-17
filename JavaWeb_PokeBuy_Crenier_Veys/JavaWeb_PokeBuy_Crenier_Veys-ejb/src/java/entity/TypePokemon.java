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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quentinveys
 */
@Entity
@Table(name = "TYPE_POKEMON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypePokemon.findAll", query = "SELECT t FROM TypePokemon t"),
    @NamedQuery(name = "TypePokemon.findByIdtype", query = "SELECT t FROM TypePokemon t WHERE t.idtype = :idtype")})
public class TypePokemon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTYPE")
    private Integer idtype;
    @ManyToMany(mappedBy = "typePokemonCollection")
    private Collection<Pokemon> pokemonCollection;
    @ManyToMany(mappedBy = "typePokemonCollection1")
    private Collection<Pokemon> pokemonCollection1;
    @JoinColumn(name = "CODEPROMOTION", referencedColumnName = "CODEPROMO")
    @ManyToOne
    private Promotion codepromotion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typePokemon")
    private Collection<TypeLangue> typeLangueCollection;

    public TypePokemon() {
    }

    public TypePokemon(Integer idtype) {
        this.idtype = idtype;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    @XmlTransient
    public Collection<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void setPokemonCollection(Collection<Pokemon> pokemonCollection) {
        this.pokemonCollection = pokemonCollection;
    }

    @XmlTransient
    public Collection<Pokemon> getPokemonCollection1() {
        return pokemonCollection1;
    }

    public void setPokemonCollection1(Collection<Pokemon> pokemonCollection1) {
        this.pokemonCollection1 = pokemonCollection1;
    }

    public Promotion getCodepromotion() {
        return codepromotion;
    }

    public void setCodepromotion(Promotion codepromotion) {
        this.codepromotion = codepromotion;
    }

    @XmlTransient
    public Collection<TypeLangue> getTypeLangueCollection() {
        return typeLangueCollection;
    }

    public void setTypeLangueCollection(Collection<TypeLangue> typeLangueCollection) {
        this.typeLangueCollection = typeLangueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtype != null ? idtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypePokemon)) {
            return false;
        }
        TypePokemon other = (TypePokemon) object;
        if ((this.idtype == null && other.idtype != null) || (this.idtype != null && !this.idtype.equals(other.idtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TypePokemon[ idtype=" + idtype + " ]";
    }
    
}
