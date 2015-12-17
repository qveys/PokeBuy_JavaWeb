/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author quentinveys
 */
@Entity
@Table(name = "POKEMON_LANGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PokemonLangue.findAll", query = "SELECT p FROM PokemonLangue p"),
    @NamedQuery(name = "PokemonLangue.findByIdlangue", query = "SELECT p FROM PokemonLangue p WHERE p.pokemonLanguePK.idlangue = :idlangue"),
    @NamedQuery(name = "PokemonLangue.findByIdpokemon", query = "SELECT p FROM PokemonLangue p WHERE p.pokemonLanguePK.idpokemon = :idpokemon"),
    @NamedQuery(name = "PokemonLangue.findByLibellepokemon", query = "SELECT p FROM PokemonLangue p WHERE p.libellepokemon = :libellepokemon"),
    @NamedQuery(name = "PokemonLangue.findByDescriptionpokemon", query = "SELECT p FROM PokemonLangue p WHERE p.descriptionpokemon = :descriptionpokemon")})
public class PokemonLangue implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PokemonLanguePK pokemonLanguePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LIBELLEPOKEMON")
    private String libellepokemon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPTIONPOKEMON")
    private String descriptionpokemon;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Langue langue;
    @JoinColumn(name = "IDPOKEMON", referencedColumnName = "IDPOKEMON", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pokemon pokemon;

    public PokemonLangue() {
    }

    public PokemonLangue(PokemonLanguePK pokemonLanguePK) {
        this.pokemonLanguePK = pokemonLanguePK;
    }

    public PokemonLangue(PokemonLanguePK pokemonLanguePK, String libellepokemon, String descriptionpokemon) {
        this.pokemonLanguePK = pokemonLanguePK;
        this.libellepokemon = libellepokemon;
        this.descriptionpokemon = descriptionpokemon;
    }

    public PokemonLangue(int idlangue, int idpokemon) {
        this.pokemonLanguePK = new PokemonLanguePK(idlangue, idpokemon);
    }

    public PokemonLanguePK getPokemonLanguePK() {
        return pokemonLanguePK;
    }

    public void setPokemonLanguePK(PokemonLanguePK pokemonLanguePK) {
        this.pokemonLanguePK = pokemonLanguePK;
    }

    public String getLibellepokemon() {
        return libellepokemon;
    }

    public void setLibellepokemon(String libellepokemon) {
        this.libellepokemon = libellepokemon;
    }

    public String getDescriptionpokemon() {
        return descriptionpokemon;
    }

    public void setDescriptionpokemon(String descriptionpokemon) {
        this.descriptionpokemon = descriptionpokemon;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pokemonLanguePK != null ? pokemonLanguePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PokemonLangue)) {
            return false;
        }
        PokemonLangue other = (PokemonLangue) object;
        if ((this.pokemonLanguePK == null && other.pokemonLanguePK != null) || (this.pokemonLanguePK != null && !this.pokemonLanguePK.equals(other.pokemonLanguePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PokemonLangue[ pokemonLanguePK=" + pokemonLanguePK + " ]";
    }
    
}
