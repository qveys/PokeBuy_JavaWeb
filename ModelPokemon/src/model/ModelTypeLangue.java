
package model;

public class ModelTypeLangue {
    private ModelType type;
    private ModelLangue langue;
    private String libelleType;
    
    public ModelTypeLangue(ModelType type, ModelLangue langue, String libelleType) {
        this.type = type;
        this.langue = langue;
        this.libelleType = libelleType;
    }

    public ModelType getType() {
        return type;
    }

    public ModelLangue getLangue() {
        return langue;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setType(ModelType type) {
        this.type = type;
    }

    public void setLangue(ModelLangue langue) {
        this.langue = langue;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }
    
}
