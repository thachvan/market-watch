package ea.mw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.mw.model.User;
import ea.mw.model.User.Role;
import ea.mw.service.UserService;
import ea.mw.validator.UserValidator;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	UserValidator userValidator;
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String displayRegisterForm() {
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		userValidator.validate(user, bindingResult);

		if (!bindingResult.hasErrors()) {
			user.setAuthority(Role.ROLE_USER);
			user.setEnabled(true);
			userService.addUser(user);
			redirectAttributes.addFlashAttribute("username",
					user.getUsername());
			redirectAttributes.addFlashAttribute("message",
					"Account has been created successfully");
			return "redirect:/login";
		}

		return "register";
	}

}
