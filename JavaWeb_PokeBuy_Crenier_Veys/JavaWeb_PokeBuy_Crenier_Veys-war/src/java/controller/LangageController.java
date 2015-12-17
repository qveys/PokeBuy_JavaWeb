
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.context.FacesContext;

@Named(value = "langageController")
@SessionScoped
public class LangageController implements Serializable {

    private static Locale locale = new Locale("fr");
    
    public LangageController() {
    }
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        LangageController.locale = locale;
    }
    
    public void setToEnglish() {
        locale = new Locale("en");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);        
    }
    
    public void setToFrancais() {
        locale = new Locale("fr");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public void setToAllemand() {
        locale = new Locale("de");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
}
