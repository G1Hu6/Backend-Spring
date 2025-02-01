package com.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.models.Student;

@Controller
public class ComplexFormController {

	@RequestMapping("/complexform")
	public String ComplexForm() {
		return "complex_form";
	}
	
	@RequestMapping(path = "/handle_complex", method = RequestMethod.POST)
	public String handleComplexForm(@ModelAttribute("student") Student student, BindingResult result) {
		
		if(result.hasErrors()) {
			return "complex_form";
		}
		System.out.println(student);
		return "output";
	}
}
