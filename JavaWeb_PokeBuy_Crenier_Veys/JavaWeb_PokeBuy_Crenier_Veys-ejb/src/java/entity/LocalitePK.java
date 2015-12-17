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
import javax.validation.constraints.Size;

/**
 *
 * @author quentinveys
 */
@Embeddable
public class LocalitePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEPOSTAL")
    private short codepostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VILLE")
    private String ville;

    public LocalitePK() {
    }

    public LocalitePK(short codepostal, String ville) {
        this.codepostal = codepostal;
        this.ville = ville;
    }

    public short getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(short codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codepostal;
        hash += (ville != null ? ville.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalitePK)) {
            return false;
        }
        LocalitePK other = (LocalitePK) object;
        if (this.codepostal != other.codepostal) {
            return false;
        }
        if ((this.ville == null && other.ville != null) || (this.ville != null && !this.ville.equals(other.ville))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LocalitePK[ codepostal=" + codepostal + ", ville=" + ville + " ]";
    }
    
}
