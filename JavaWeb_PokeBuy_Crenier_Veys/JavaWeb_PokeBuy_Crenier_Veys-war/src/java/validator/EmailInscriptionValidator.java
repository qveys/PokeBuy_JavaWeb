package validator;

import business.PokemonSessionBeanLocal;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@FacesValidator("emailInscriptionValidator")
public class EmailInscriptionValidator implements Validator {
    
    
    PokemonSessionBeanLocal pokemonSessionBean = lookupPokemonSessionBeanLocal();

    public PokemonSessionBeanLocal getPokemonSessionBean() {
        return pokemonSessionBean;
    }

    public void setPokemonSessionBean(PokemonSessionBeanLocal pokemonSessionBean) {
        this.pokemonSessionBean = pokemonSessionBean;
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String mail = (String) value.toString().toUpperCase();
        ResourceBundle bundle = ResourceBundle.getBundle("languages.lang");
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (!mail.matches(pattern)) {
            FacesMessage fm = new FacesMessage(bundle.getString("emailInvalide"));
            throw new ValidatorException(fm);
        } else {
            if (isOneClientByEmail(mail)) {
                FacesMessage fm = new FacesMessage(bundle.getString("clientExistant"));
                throw new ValidatorException(fm);
            }
        }
    }

    public boolean isOneClientByEmail(String mail) {
        return getPokemonSessionBean().isOneClientByEmail(mail);
    }

    private PokemonSessionBeanLocal lookupPokemonSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (PokemonSessionBeanLocal) c.lookup("java:global/JavaWeb_PokeBuy_Crenier_Veys/JavaWeb_PokeBuy_Crenier_Veys-ejb/PokemonSessionBean!business.PokemonSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
