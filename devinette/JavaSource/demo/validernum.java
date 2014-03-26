package demo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.facelets.tag.jsf.ValidatorConfig;




public class validernum implements Validator {
	private static final String caractere =
	"[0-9]+";
	public void validate(FacesContext arg0,
	UIComponent arg1, Object value)
	throws ValidatorException {
	Pattern mask = Pattern.compile(caractere);
	CharSequence nom = value.toString();
	Matcher matcher = mask.matcher(nom);
	if (!matcher.matches()){
	FacesMessage message = new FacesMessage();
	message.setDetail("Non valide");
	message.setSummary("Non valide");
	message.setSeverity(
	FacesMessage.SEVERITY_ERROR);
	throw new ValidatorException(message);
	}
	}
	}