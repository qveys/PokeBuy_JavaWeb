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
import javax.persistence.ManyToMany;
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
@Table(name = "TALENT_POKEMON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TalentPokemon.findAll", query = "SELECT t FROM TalentPokemon t"),
    @NamedQuery(name = "TalentPokemon.findByIdtalent", query = "SELECT t FROM TalentPokemon t WHERE t.idtalent = :idtalent")})
public class TalentPokemon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTALENT")
    private Integer idtalent;
    @ManyToMany(mappedBy = "talentPokemonCollection")
    private Collection<Pokemon> pokemonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talentPokemon")
    private Collection<TalentLangue> talentLangueCollection;

    public TalentPokemon() {
    }

    public TalentPokemon(Integer idtalent) {
        this.idtalent = idtalent;
    }

    public Integer getIdtalent() {
        return idtalent;
    }

    public void setIdtalent(Integer idtalent) {
        this.idtalent = idtalent;
    }

    @XmlTransient
    public Collection<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void setPokemonCollection(Collection<Pokemon> pokemonCollection) {
        this.pokemonCollection = pokemonCollection;
    }

    @XmlTransient
    public Collection<TalentLangue> getTalentLangueCollection() {
        return talentLangueCollection;
    }

    public void setTalentLangueCollection(Collection<TalentLangue> talentLangueCollection) {
        this.talentLangueCollection = talentLangueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtalent != null ? idtalent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TalentPokemon)) {
            return false;
        }
        TalentPokemon other = (TalentPokemon) object;
        if ((this.idtalent == null && other.idtalent != null) || (this.idtalent != null && !this.idtalent.equals(other.idtalent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TalentPokemon[ idtalent=" + idtalent + " ]";
    }
    
}
