package ea.mw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ea.mw.model.PortfolioItem;
import ea.mw.model.PortfolioItem.TradingType;
import ea.mw.model.Symbol;
import ea.mw.model.TableRecord;
import ea.mw.model.User;
import ea.mw.service.SymbolService;
import ea.mw.service.UserService;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	@Autowired
	private UserService userService;
	@Autowired
	private SymbolService synbolService;

	private User user;

	@RequestMapping(method = RequestMethod.GET)
	public String displayPortfolio(ModelMap modelMap) {
		updateAuthenticatedUser();
		modelMap.addAttribute("portfolio", userService.getPortfolio(user));
		modelMap.addAttribute("name", user.getName());
		modelMap.addAttribute("symbols", synbolService.listSymbols());

		return "portfolio";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPortfolio(@RequestParam("name") String name,
			@RequestParam(value = "volume", required = false) double volume,
			@RequestParam(value = "originalPrice", required = false) double originalPrice,
			@RequestParam(value = "type") String type) {
		updateAuthenticatedUser();
		TradingType tradingType = TradingType.valueOf(type);
		PortfolioItem item = new PortfolioItem(new Symbol(name), volume,
				originalPrice, tradingType);
		userService.addPortfolioItem(user, item);

		return "redirect:/portfolio";
	}

	@RequestMapping(value = "/getjson", method = RequestMethod.GET)
	public @ResponseBody List<TableRecord> getJson() {
		updateAuthenticatedUser();
		List<PortfolioItem> portfolio = user.getPortfolio();
		List<TableRecord> records = new ArrayList<TableRecord>();

		for (PortfolioItem item : portfolio) {
			TableRecord record = new TableRecord();

			record.setSymbolName(item.getSymbol().getName());
			record.setVolume(item.getVolume());
			record.setOriginalPrice(item.getOrginalPrice());
			record.setType(item.getType());
			record.setAsk(item.getSymbol().getAsk());
			record.setBid(item.getSymbol().getBid());
			if (item.getType() == TradingType.BUY) {
				record.setProfit(
						item.getSymbol().getBid() - item.getOrginalPrice());
			} else {
				record.setProfit(
						item.getSymbol().getAsk() - item.getOrginalPrice());
			}
			
			records.add(record);
		}

		return records;
	}

	private void updateAuthenticatedUser() {
		UserDetails currentUserDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		user = userService.getUser(currentUserDetails.getUsername());
	}
}
