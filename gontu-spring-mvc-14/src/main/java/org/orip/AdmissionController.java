package org.orip;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {

	@ModelAttribute
	public void populateModel(Model model) {
		model.addAttribute("title", "Gontu College of Engineering, India");
	}
	
	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView admissionForm() {
		
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute Student student, BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView("submitAdmissionForm");
		
		if (result.hasErrors()) {
			return modelAndView;
		}
		
		
		return modelAndView;
		
	}
}
