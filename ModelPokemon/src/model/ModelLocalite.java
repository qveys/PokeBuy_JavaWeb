
package model;

public class ModelLocalite {
    private Short codePostal;
    private String ville;

    public ModelLocalite(Short codePostal, String ville) {
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Short getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Short codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }    
}
