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
@Table(name = "TYPE_LANGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeLangue.findAll", query = "SELECT t FROM TypeLangue t"),
    @NamedQuery(name = "TypeLangue.findByIdlangue", query = "SELECT t FROM TypeLangue t WHERE t.typeLanguePK.idlangue = :idlangue"),
    @NamedQuery(name = "TypeLangue.findByIdtype", query = "SELECT t FROM TypeLangue t WHERE t.typeLanguePK.idtype = :idtype"),
    @NamedQuery(name = "TypeLangue.findByLibelletype", query = "SELECT t FROM TypeLangue t WHERE t.libelletype = :libelletype")})
public class TypeLangue implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TypeLanguePK typeLanguePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LIBELLETYPE")
    private String libelletype;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Langue langue;
    @JoinColumn(name = "IDTYPE", referencedColumnName = "IDTYPE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TypePokemon typePokemon;

    public TypeLangue() {
    }

    public TypeLangue(TypeLanguePK typeLanguePK) {
        this.typeLanguePK = typeLanguePK;
    }

    public TypeLangue(TypeLanguePK typeLanguePK, String libelletype) {
        this.typeLanguePK = typeLanguePK;
        this.libelletype = libelletype;
    }

    public TypeLangue(int idlangue, int idtype) {
        this.typeLanguePK = new TypeLanguePK(idlangue, idtype);
    }

    public TypeLanguePK getTypeLanguePK() {
        return typeLanguePK;
    }

    public void setTypeLanguePK(TypeLanguePK typeLanguePK) {
        this.typeLanguePK = typeLanguePK;
    }

    public String getLibelletype() {
        return libelletype;
    }

    public void setLibelletype(String libelletype) {
        this.libelletype = libelletype;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public TypePokemon getTypePokemon() {
        return typePokemon;
    }

    public void setTypePokemon(TypePokemon typePokemon) {
        this.typePokemon = typePokemon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeLanguePK != null ? typeLanguePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeLangue)) {
            return false;
        }
        TypeLangue other = (TypeLangue) object;
        if ((this.typeLanguePK == null && other.typeLanguePK != null) || (this.typeLanguePK != null && !this.typeLanguePK.equals(other.typeLanguePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TypeLangue[ typeLanguePK=" + typeLanguePK + " ]";
    }
    
}
