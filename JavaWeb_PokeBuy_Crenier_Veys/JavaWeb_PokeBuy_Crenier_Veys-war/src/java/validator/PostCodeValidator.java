
package validator;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("postCodeValidator")
public class PostCodeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Integer postCode = ((Number) value).intValue();

        ResourceBundle bundle = ResourceBundle.getBundle("languages.lang");

        if (postCode < 1000 || postCode > 9999) {
            FacesMessage fm = new FacesMessage(bundle.getString("erreurQuatreChiffre"));
            throw new ValidatorException(fm);
        }
    }
}
