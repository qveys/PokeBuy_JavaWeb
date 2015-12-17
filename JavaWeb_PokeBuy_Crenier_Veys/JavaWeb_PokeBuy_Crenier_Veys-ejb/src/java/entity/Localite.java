/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "LOCALITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localite.findAll", query = "SELECT l FROM Localite l"),
    @NamedQuery(name = "Localite.findByCodepostal", query = "SELECT l FROM Localite l WHERE l.localitePK.codepostal = :codepostal"),
    @NamedQuery(name = "Localite.findByVille", query = "SELECT l FROM Localite l WHERE l.localitePK.ville = :ville")})
public class Localite implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalitePK localitePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localite")
    private Collection<Client> clientCollection;

    public Localite() {
    }

    public Localite(LocalitePK localitePK) {
        this.localitePK = localitePK;
    }

    public Localite(short codepostal, String ville) {
        this.localitePK = new LocalitePK(codepostal, ville);
    }

    public LocalitePK getLocalitePK() {
        return localitePK;
    }

    public void setLocalitePK(LocalitePK localitePK) {
        this.localitePK = localitePK;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localitePK != null ? localitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localite)) {
            return false;
        }
        Localite other = (Localite) object;
        if ((this.localitePK == null && other.localitePK != null) || (this.localitePK != null && !this.localitePK.equals(other.localitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Localite[ localitePK=" + localitePK + " ]";
    }
    
}
