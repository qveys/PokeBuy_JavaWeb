
package model;

public class ModelPromo {
    private String codePromo;
    private double pourcentagePromo;

    public ModelPromo(String codePromo, double pourcentagePromo) {
        this.codePromo = codePromo;
        this.pourcentagePromo = pourcentagePromo;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public double getPourcentagePromo() {
        return pourcentagePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }

    public void setPourcentagePromo(double pourcentagePromo) {
        this.pourcentagePromo = pourcentagePromo;
    }
    
}
