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
public class LignecommandePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMCOMMANDE")
    private int numcommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMLIGNE")
    private int numligne;

    public LignecommandePK() {
    }

    public LignecommandePK(int numcommande, int numligne) {
        this.numcommande = numcommande;
        this.numligne = numligne;
    }

    public int getNumcommande() {
        return numcommande;
    }

    public void setNumcommande(int numcommande) {
        this.numcommande = numcommande;
    }

    public int getNumligne() {
        return numligne;
    }

    public void setNumligne(int numligne) {
        this.numligne = numligne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numcommande;
        hash += (int) numligne;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LignecommandePK)) {
            return false;
        }
        LignecommandePK other = (LignecommandePK) object;
        if (this.numcommande != other.numcommande) {
            return false;
        }
        if (this.numligne != other.numligne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LignecommandePK[ numcommande=" + numcommande + ", numligne=" + numligne + " ]";
    }
    
}
