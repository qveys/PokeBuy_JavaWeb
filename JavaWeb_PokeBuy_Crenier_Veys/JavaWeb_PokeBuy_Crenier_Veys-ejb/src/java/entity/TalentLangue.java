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
@Table(name = "TALENT_LANGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TalentLangue.findAll", query = "SELECT t FROM TalentLangue t"),
    @NamedQuery(name = "TalentLangue.findByIdtalent", query = "SELECT t FROM TalentLangue t WHERE t.talentLanguePK.idtalent = :idtalent"),
    @NamedQuery(name = "TalentLangue.findByIdlangue", query = "SELECT t FROM TalentLangue t WHERE t.talentLanguePK.idlangue = :idlangue"),
    @NamedQuery(name = "TalentLangue.findByLibelletalent", query = "SELECT t FROM TalentLangue t WHERE t.libelletalent = :libelletalent"),
    @NamedQuery(name = "TalentLangue.findByDescriptiontalent", query = "SELECT t FROM TalentLangue t WHERE t.descriptiontalent = :descriptiontalent")})
public class TalentLangue implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TalentLanguePK talentLanguePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LIBELLETALENT")
    private String libelletalent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPTIONTALENT")
    private String descriptiontalent;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Langue langue;
    @JoinColumn(name = "IDTALENT", referencedColumnName = "IDTALENT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TalentPokemon talentPokemon;

    public TalentLangue() {
    }

    public TalentLangue(TalentLanguePK talentLanguePK) {
        this.talentLanguePK = talentLanguePK;
    }

    public TalentLangue(TalentLanguePK talentLanguePK, String libelletalent, String descriptiontalent) {
        this.talentLanguePK = talentLanguePK;
        this.libelletalent = libelletalent;
        this.descriptiontalent = descriptiontalent;
    }

    public TalentLangue(int idtalent, int idlangue) {
        this.talentLanguePK = new TalentLanguePK(idtalent, idlangue);
    }

    public TalentLanguePK getTalentLanguePK() {
        return talentLanguePK;
    }

    public void setTalentLanguePK(TalentLanguePK talentLanguePK) {
        this.talentLanguePK = talentLanguePK;
    }

    public String getLibelletalent() {
        return libelletalent;
    }

    public void setLibelletalent(String libelletalent) {
        this.libelletalent = libelletalent;
    }

    public String getDescriptiontalent() {
        return descriptiontalent;
    }

    public void setDescriptiontalent(String descriptiontalent) {
        this.descriptiontalent = descriptiontalent;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public TalentPokemon getTalentPokemon() {
        return talentPokemon;
    }

    public void setTalentPokemon(TalentPokemon talentPokemon) {
        this.talentPokemon = talentPokemon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talentLanguePK != null ? talentLanguePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TalentLangue)) {
            return false;
        }
        TalentLangue other = (TalentLangue) object;
        if ((this.talentLanguePK == null && other.talentLanguePK != null) || (this.talentLanguePK != null && !this.talentLanguePK.equals(other.talentLanguePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TalentLangue[ talentLanguePK=" + talentLanguePK + " ]";
    }
    
}
