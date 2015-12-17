/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quentinveys
 */
@Entity
@Table(name = "COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByNumcommande", query = "SELECT c FROM Commande c WHERE c.numcommande = :numcommande"),
    @NamedQuery(name = "Commande.findByDatecommande", query = "SELECT c FROM Commande c WHERE c.datecommande = :datecommande"),
    @NamedQuery(name = "Commande.lastNumCommande", query = "SELECT max(c.numcommande) FROM Commande c"),
    @NamedQuery(name = "Commande.findByDatelivraison", query = "SELECT c FROM Commande c WHERE c.datelivraison = :datelivraison")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMCOMMANDE")
    private Integer numcommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECOMMANDE")
    @Temporal(TemporalType.DATE)
    private Date datecommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATELIVRAISON")
    @Temporal(TemporalType.DATE)
    private Date datelivraison;
    @JoinColumn(name = "NUMCLIENT", referencedColumnName = "NUMCLIENT")
    @ManyToOne(optional = false)
    private Client numclient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<Lignecommande> lignecommandeCollection;

    public Commande() {
    }

    public Commande(Integer numcommande) {
        this.numcommande = numcommande;
    }

    public Commande(Integer numcommande, Date datecommande, Date datelivraison) {
        this.numcommande = numcommande;
        this.datecommande = datecommande;
        this.datelivraison = datelivraison;
    }

    public Integer getNumcommande() {
        return numcommande;
    }

    public void setNumcommande(Integer numcommande) {
        this.numcommande = numcommande;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public Date getDatelivraison() {
        return datelivraison;
    }

    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }

    public Client getNumclient() {
        return numclient;
    }

    public void setNumclient(Client numclient) {
        this.numclient = numclient;
    }

    @XmlTransient
    public Collection<Lignecommande> getLignecommandeCollection() {
        return lignecommandeCollection;
    }

    public void setLignecommandeCollection(Collection<Lignecommande> lignecommandeCollection) {
        this.lignecommandeCollection = lignecommandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcommande != null ? numcommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.numcommande == null && other.numcommande != null) || (this.numcommande != null && !this.numcommande.equals(other.numcommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Commande[ numcommande=" + numcommande + " ]";
    }
    
}
