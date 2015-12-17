
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

@Entity
@Table(name = "CATEGORIE_LANGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategorieLangue.findAll", query = "SELECT c FROM CategorieLangue c"),
    @NamedQuery(name = "CategorieLangue.findByIdcategorie", query = "SELECT c FROM CategorieLangue c WHERE c.categorieLanguePK.idcategorie = :idcategorie"),
    @NamedQuery(name = "CategorieLangue.findByIdlangue", query = "SELECT c FROM CategorieLangue c WHERE c.categorieLanguePK.idlangue = :idlangue"),
    @NamedQuery(name = "CategorieLangue.findByLibellecategorie", query = "SELECT c FROM CategorieLangue c WHERE c.libellecategorie = :libellecategorie")})
public class CategorieLangue implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategorieLanguePK categorieLanguePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LIBELLECATEGORIE")
    private String libellecategorie;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "IDCATEGORIE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CategoriePokemon categoriePokemon;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Langue langue;

    public CategorieLangue() {
    }

    public CategorieLangue(CategorieLanguePK categorieLanguePK) {
        this.categorieLanguePK = categorieLanguePK;
    }

    public CategorieLangue(CategorieLanguePK categorieLanguePK, String libellecategorie) {
        this.categorieLanguePK = categorieLanguePK;
        this.libellecategorie = libellecategorie;
    }

    public CategorieLangue(int idcategorie, int idlangue) {
        this.categorieLanguePK = new CategorieLanguePK(idcategorie, idlangue);
    }

    public CategorieLanguePK getCategorieLanguePK() {
        return categorieLanguePK;
    }

    public void setCategorieLanguePK(CategorieLanguePK categorieLanguePK) {
        this.categorieLanguePK = categorieLanguePK;
    }

    public String getLibellecategorie() {
        return libellecategorie;
    }

    public void setLibellecategorie(String libellecategorie) {
        this.libellecategorie = libellecategorie;
    }

    public CategoriePokemon getCategoriePokemon() {
        return categoriePokemon;
    }

    public void setCategoriePokemon(CategoriePokemon categoriePokemon) {
        this.categoriePokemon = categoriePokemon;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categorieLanguePK != null ? categorieLanguePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieLangue)) {
            return false;
        }
        CategorieLangue other = (CategorieLangue) object;
        if ((this.categorieLanguePK == null && other.categorieLanguePK != null) || (this.categorieLanguePK != null && !this.categorieLanguePK.equals(other.categorieLanguePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CategorieLangue[ categorieLanguePK=" + categorieLanguePK + " ]";
    }
    
}
