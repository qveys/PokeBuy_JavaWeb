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
public class TalentLanguePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTALENT")
    private int idtalent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;

    public TalentLanguePK() {
    }

    public TalentLanguePK(int idtalent, int idlangue) {
        this.idtalent = idtalent;
        this.idlangue = idlangue;
    }

    public int getIdtalent() {
        return idtalent;
    }

    public void setIdtalent(int idtalent) {
        this.idtalent = idtalent;
    }

    public int getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(int idlangue) {
        this.idlangue = idlangue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtalent;
        hash += (int) idlangue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TalentLanguePK)) {
            return false;
        }
        TalentLanguePK other = (TalentLanguePK) object;
        if (this.idtalent != other.idtalent) {
            return false;
        }
        if (this.idlangue != other.idlangue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TalentLanguePK[ idtalent=" + idtalent + ", idlangue=" + idlangue + " ]";
    }
    
}
