package org.orip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {

	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView admissionForm() {
		
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String studentName, 
			@RequestParam("studentHobby") String studentHobby) {
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby(studentHobby);
		
		ModelAndView modelAndView = new ModelAndView("submitAdmissionForm");
		
		modelAndView.addObject("student", student);
		
		return modelAndView;
		
	}
}
