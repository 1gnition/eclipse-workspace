package org.orip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController {

	@RequestMapping("/welcome.html")
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		
		modelAndView.addObject("helloMsg", "Welcome to my MVC");
		
		return modelAndView;
	}
	
	@RequestMapping("/hi.html")
	public ModelAndView hi() {
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("helloMsg", "Hi there!");

		return modelAndView;
	}
}
