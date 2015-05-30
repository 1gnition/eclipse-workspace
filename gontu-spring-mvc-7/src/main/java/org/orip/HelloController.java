package org.orip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome.html")
	public ModelAndView handle() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("helloMsg", "Welcome to my MVC");

		return modelAndView;
	}
}
