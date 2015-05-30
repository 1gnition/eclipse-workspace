package org.orip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome/{userName}")
	public ModelAndView welcome(@PathVariable("userName") String userName) {
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		
		modelAndView.addObject("helloMsg", "Welcome, " + userName);
		
		return modelAndView;
	}
}
