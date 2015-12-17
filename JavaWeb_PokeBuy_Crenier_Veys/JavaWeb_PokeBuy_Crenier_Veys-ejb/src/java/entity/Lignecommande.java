/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author quentinveys
 */
@Entity
@Table(name = "LIGNECOMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignecommande.findAll", query = "SELECT l FROM Lignecommande l"),
    @NamedQuery(name = "Lignecommande.findByNumcommande", query = "SELECT l FROM Lignecommande l WHERE l.lignecommandePK.numcommande = :numcommande"),
    @NamedQuery(name = "Lignecommande.findByNumligne", query = "SELECT l FROM Lignecommande l WHERE l.lignecommandePK.numligne = :numligne"),
    @NamedQuery(name = "Lignecommande.findByQuantite", query = "SELECT l FROM Lignecommande l WHERE l.quantite = :quantite"),
    @NamedQuery(name = "Lignecommande.findByPrixunitaire", query = "SELECT l FROM Lignecommande l WHERE l.prixunitaire = :prixunitaire")})
public class Lignecommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LignecommandePK lignecommandePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITE")
    private short quantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXUNITAIRE")
    private BigDecimal prixunitaire;
    @JoinColumn(name = "NUMCOMMANDE", referencedColumnName = "NUMCOMMANDE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "IDPOKEMON", referencedColumnName = "IDPOKEMON")
    @ManyToOne(optional = false)
    private Pokemon idpokemon;

    public Lignecommande() {
    }

    public Lignecommande(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    public Lignecommande(LignecommandePK lignecommandePK, short quantite, BigDecimal prixunitaire) {
        this.lignecommandePK = lignecommandePK;
        this.quantite = quantite;
        this.prixunitaire = prixunitaire;
    }

    public Lignecommande(int numcommande, int numligne) {
        this.lignecommandePK = new LignecommandePK(numcommande, numligne);
    }

    public LignecommandePK getLignecommandePK() {
        return lignecommandePK;
    }

    public void setLignecommandePK(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    public short getQuantite() {
        return quantite;
    }

    public void setQuantite(short quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(BigDecimal prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Pokemon getIdpokemon() {
        return idpokemon;
    }

    public void setIdpokemon(Pokemon idpokemon) {
        this.idpokemon = idpokemon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lignecommandePK != null ? lignecommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignecommande)) {
            return false;
        }
        Lignecommande other = (Lignecommande) object;
        if ((this.lignecommandePK == null && other.lignecommandePK != null) || (this.lignecommandePK != null && !this.lignecommandePK.equals(other.lignecommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lignecommande[ lignecommandePK=" + lignecommandePK + " ]";
    }
    
}
