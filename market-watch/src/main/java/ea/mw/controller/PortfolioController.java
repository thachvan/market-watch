package ea.mw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ea.mw.model.PortfolioItem;
import ea.mw.model.PortfolioItem.TradingType;
import ea.mw.model.Symbol;
import ea.mw.model.User;
import ea.mw.service.UserService;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	@Autowired
	private UserService userService;

	private User user;

	@RequestMapping(method = RequestMethod.GET)
	public String displayPortfolio(ModelMap modelMap) {
		UserDetails currentUserDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		user = userService.getUser(currentUserDetails.getUsername());
		modelMap.addAttribute("portfolio", userService.getPortfolio(user));
		modelMap.addAttribute("name", user.getName());

		return "portfolio";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPortfolio(@RequestParam("name") String name,
			@RequestParam(value = "volume", required = false) Double volume,
			@RequestParam(value = "originalPrice", required = false) Double originalPrice,
			@RequestParam(value = "type", required = false) TradingType type) {
		PortfolioItem item = new PortfolioItem(new Symbol(name), volume,
				originalPrice, type);
		userService.addPortfolioItem(user, item);

		return "portfolio";
	}
}
