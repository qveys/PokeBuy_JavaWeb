
package validator;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        ResourceBundle bundle = ResourceBundle.getBundle("languages.lang");
        if (password.length() < 8) {
            FacesMessage fm = new FacesMessage(bundle.getString("erreurHuitCaract"));
            throw new ValidatorException(fm);
        } else {
            if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[^\\s]{8,}$")) {
                String erreur = "";
                /* Contient au moins 1 chiffre */
                if (!password.matches("^(?=.*\\d)[^\\s]{8,}$")) {
                    erreur += bundle.getString("erreurUnChiffre");
                }

                /* Contient au moins 1 minuscule */
                if (!password.matches("^(?=.*[a-z])[^\\s]{8,}$")) {
                    erreur += ((erreur.length() > 0) ? ", " : "") + bundle.getString("erreurUneMinuscule");
                }

                /* Contient au moins 1 majuscule */
                if (!password.matches("^(?=.*[A-Z])[^\\s]{8,}$")) {
                    erreur += ((erreur.length() > 0) ? ", " : "") + bundle.getString("erreurUneMajuscule");
                }

                FacesMessage fm = new FacesMessage(erreur);
                throw new ValidatorException(fm);
            }
        }
    }
}

