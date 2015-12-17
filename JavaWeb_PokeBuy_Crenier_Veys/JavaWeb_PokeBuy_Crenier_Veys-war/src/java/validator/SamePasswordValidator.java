package validator;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("samePasswordValidator")
public class SamePasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String mdp1 = (String) component.getAttributes().get("mdp1");
        String mdp2 = (String) value;

        if (!mdp1.equals(mdp2)) {
            ResourceBundle bundle = ResourceBundle.getBundle("languages.lang");
            FacesMessage mess = new FacesMessage(bundle.getString("passwordIdentique"));
            throw new ValidatorException(mess);
        }

    }
}
