
package model;

public class ModelType {
    private Integer idType;
    private ModelPromo promo;
    
    public ModelType(Integer idType, ModelPromo promo) {
        this.idType = idType;
        this.promo = promo;
    }

    public Integer getIdType() {
        return idType;
    }

    public ModelPromo getPromo() {
        return promo;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public void setPromo(ModelPromo promo) {
        this.promo = promo;
    }
    
    public String getClassType() {
        return "background-type" + idType;
    }
    
    public String getSortingType() {
        return "type" + idType;
    }    
}
