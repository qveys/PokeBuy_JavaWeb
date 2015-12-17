
package model;

public class ModelCategorieLangue {
    private ModelCategorie categorie;
    private ModelLangue langue;
    private String libelleCategorie;

    public ModelCategorieLangue(ModelCategorie categorie, ModelLangue langue, String libelleCategorie) {
        this.categorie = categorie;
        this.langue = langue;
        this.libelleCategorie = libelleCategorie;
    }

    public ModelCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ModelCategorie categorie) {
        this.categorie = categorie;
    }

    public ModelLangue getLangue() {
        return langue;
    }

    public void setLangue(ModelLangue langue) {
        this.langue = langue;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }
    
}
