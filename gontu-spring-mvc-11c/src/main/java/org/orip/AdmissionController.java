package org.orip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {

	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView admissionForm() {
		
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		modelAndView.addObject("title", "Gontu College of Engineering, India");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute Student student) {
		
		ModelAndView modelAndView = new ModelAndView("submitAdmissionForm");
		modelAndView.addObject("title", "Gontu College of Engineering, India");
		
		return modelAndView;
		
	}
}
