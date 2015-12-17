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
public class CategorieLanguePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCATEGORIE")
    private int idcategorie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;

    public CategorieLanguePK() {
    }

    public CategorieLanguePK(int idcategorie, int idlangue) {
        this.idcategorie = idcategorie;
        this.idlangue = idlangue;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
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
        hash += (int) idcategorie;
        hash += (int) idlangue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieLanguePK)) {
            return false;
        }
        CategorieLanguePK other = (CategorieLanguePK) object;
        if (this.idcategorie != other.idcategorie) {
            return false;
        }
        if (this.idlangue != other.idlangue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CategorieLanguePK[ idcategorie=" + idcategorie + ", idlangue=" + idlangue + " ]";
    }
    
}
