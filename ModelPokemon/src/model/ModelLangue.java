
package model;

public class ModelLangue {
    private Integer idLangue;
    private String codeLangue;
    private String libelleLangue;
    
    public ModelLangue(Integer idLangue, String codeLangue, String libelleLangue) {
        this.idLangue = idLangue;
        this.codeLangue = codeLangue;
        this.libelleLangue = libelleLangue;
    }

    public Integer getIdLangue() {
        return idLangue;
    }

    public String getCodeLangue() {
        return codeLangue;
    }

    public String getLibelleLangue() {
        return libelleLangue;
    }

    public void setIdLangue(Integer idLangue) {
        this.idLangue = idLangue;
    }

    public void setCodeLangue(String codeLangue) {
        this.codeLangue = codeLangue;
    }

    public void setLibelleLangue(String libelleLangue) {
        this.libelleLangue = libelleLangue;
    }
    
}
