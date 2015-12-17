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
public class TypeLanguePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTYPE")
    private int idtype;

    public TypeLanguePK() {
    }

    public TypeLanguePK(int idlangue, int idtype) {
        this.idlangue = idlangue;
        this.idtype = idtype;
    }

    public int getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(int idlangue) {
        this.idlangue = idlangue;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlangue;
        hash += (int) idtype;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeLanguePK)) {
            return false;
        }
        TypeLanguePK other = (TypeLanguePK) object;
        if (this.idlangue != other.idlangue) {
            return false;
        }
        if (this.idtype != other.idtype) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TypeLanguePK[ idlangue=" + idlangue + ", idtype=" + idtype + " ]";
    }
    
}
