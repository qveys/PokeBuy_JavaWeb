/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quentinveys
 */
@Entity
@Table(name = "PROMOTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByCodepromo", query = "SELECT p FROM Promotion p WHERE p.codepromo = :codepromo"),
    @NamedQuery(name = "Promotion.findByPourcentagepromo", query = "SELECT p FROM Promotion p WHERE p.pourcentagepromo = :pourcentagepromo")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODEPROMO")
    private String codepromo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "POURCENTAGEPROMO")
    private BigDecimal pourcentagepromo;
    @OneToMany(mappedBy = "codepromotion")
    private Collection<TypePokemon> typePokemonCollection;

    public Promotion() {
    }

    public Promotion(String codepromo) {
        this.codepromo = codepromo;
    }

    public Promotion(String codepromo, BigDecimal pourcentagepromo) {
        this.codepromo = codepromo;
        this.pourcentagepromo = pourcentagepromo;
    }

    public String getCodepromo() {
        return codepromo;
    }

    public void setCodepromo(String codepromo) {
        this.codepromo = codepromo;
    }

    public BigDecimal getPourcentagepromo() {
        return pourcentagepromo;
    }

    public void setPourcentagepromo(BigDecimal pourcentagepromo) {
        this.pourcentagepromo = pourcentagepromo;
    }

    @XmlTransient
    public Collection<TypePokemon> getTypePokemonCollection() {
        return typePokemonCollection;
    }

    public void setTypePokemonCollection(Collection<TypePokemon> typePokemonCollection) {
        this.typePokemonCollection = typePokemonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codepromo != null ? codepromo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.codepromo == null && other.codepromo != null) || (this.codepromo != null && !this.codepromo.equals(other.codepromo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Promotion[ codepromo=" + codepromo + " ]";
    }
    
}
