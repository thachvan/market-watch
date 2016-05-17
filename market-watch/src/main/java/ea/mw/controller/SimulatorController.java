package ea.mw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sim")
public class SimulatorController {
	@RequestMapping(method = RequestMethod.GET)
	public String startSimulator() {
		return "simulator";
	}
}
