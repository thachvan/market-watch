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
	public String register(@Valid User user, BindingResult result, ModelMap modelMap) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(user);
		
		String view;
		
		if (!result.hasErrors()) {
			System.out.println("No errors");
			view = "login";
		}
		else {
			view = "register";
		}
		
		return view;
	}
}
