package ea.mw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ea.mw.model.Symbol;
import ea.mw.service.SymbolService;

@Controller
@RequestMapping("/symbol")
public class SymbolController {
	@Autowired
	private SymbolService symbolService;

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateSymbol(@RequestParam("name") String name,
			@RequestParam(value = "ask") Double ask,
			@RequestParam(value = "bid") Double bid) {
		Symbol symbol = new Symbol(name, ask, bid);
		symbolService.saveSymbol(symbol);
	}
}
