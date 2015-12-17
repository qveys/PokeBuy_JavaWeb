/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author quentinveys
 */
@Embeddable
public class PokemonLanguePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOKEMON")
    private int idpokemon;

    public PokemonLanguePK() {
    }

    public PokemonLanguePK(int idlangue, int idpokemon) {
        this.idlangue = idlangue;
        this.idpokemon = idpokemon;
    }

    public int getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(int idlangue) {
        this.idlangue = idlangue;
    }

    public int getIdpokemon() {
        return idpokemon;
    }

    public void setIdpokemon(int idpokemon) {
        this.idpokemon = idpokemon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlangue;
        hash += (int) idpokemon;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PokemonLanguePK)) {
            return false;
        }
        PokemonLanguePK other = (PokemonLanguePK) object;
        if (this.idlangue != other.idlangue) {
            return false;
        }
        if (this.idpokemon != other.idpokemon) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PokemonLanguePK[ idlangue=" + idlangue + ", idpokemon=" + idpokemon + " ]";
    }
    
}
