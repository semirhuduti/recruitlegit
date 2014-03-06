/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
@FacesValidator("util.validators.NameValidator")
public class NameValidator implements Validator{
 
	private static final String EMAIL_PATTERN = "([a-zA-Z]{3,30}\\s*)+";
 
	private Pattern pattern;
	private Matcher matcher;
 
	public NameValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
 
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
 
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
                    
                    if(FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage().equals("en")){
                        FacesMessage msg = 
				new FacesMessage("Name validation failed.", 
						"Invalid name format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
                    }else{
                        FacesMessage msg = 
				new FacesMessage("Namn validation misslyckades.", 
						"Ogiltigt namn format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
                    }
 
		}
 
	}
}