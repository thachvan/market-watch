package ea.mw.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ea.mw.model.User;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@RequestMapping(method = RequestMethod.GET)
	public String displayRegisterForm() {
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(user);
		
		if (!bindingResult.hasErrors()) {
			System.out.println("No errors");
			return "redirect:/login";
		}

		System.out.println("Has errors");
		modelMap.put(BindingResult.class.getName() + ".user", bindingResult);
		
		return "register";
	}
}
