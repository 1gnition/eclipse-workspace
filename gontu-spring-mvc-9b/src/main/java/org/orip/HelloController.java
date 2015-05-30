package org.orip;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome/{country}/{userName}")
	public ModelAndView welcome(@PathVariable Map<String, String> args) {
		
		String country = args.get("country");
		String userName = args.get("userName");
		
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		
		modelAndView.addObject("helloMsg", "Welcome, " + userName + " You are from " + country);
		
		return modelAndView;
	}
}
