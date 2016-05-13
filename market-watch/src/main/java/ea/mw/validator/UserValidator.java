package ea.mw.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ea.mw.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "Username is required");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password", "Password is required");
	}
	
}
