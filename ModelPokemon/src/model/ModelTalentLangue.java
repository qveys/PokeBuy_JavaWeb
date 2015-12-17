
package model;

public class ModelTalentLangue {
    private ModelTalent talent;
    private ModelLangue langue;
    private String libelleTalent;
    private String descriptionTalent;
    
    public ModelTalentLangue(ModelTalent talent, ModelLangue langue, String libelleTalent, String descriptionTalent) {
        this.talent = talent;
        this.langue = langue;
        this.libelleTalent = libelleTalent;
        this.descriptionTalent = descriptionTalent;
    }

    public ModelTalent getTalent() {
        return talent;
    }

    public void setTalent(ModelTalent talent) {
        this.talent = talent;
    }

    public ModelLangue getLangue() {
        return langue;
    }

    public void setLangue(ModelLangue langue) {
        this.langue = langue;
    }

    public String getLibelleTalent() {
        return libelleTalent;
    }

    public void setLibelleTalent(String libelleTalent) {
        this.libelleTalent = libelleTalent;
    }

    public String getDescriptionTalent() {
        return descriptionTalent;
    }

    public void setDescriptionTalent(String descriptionTalent) {
        this.descriptionTalent = descriptionTalent;
    }
    
}
