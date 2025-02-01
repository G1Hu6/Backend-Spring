package com.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.models.User;
import com.mvc.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InfoController {

	@Autowired
	private UserService userService;
	
	// Common data are added here and called automatically before executing other method
	@ModelAttribute
	void commomDataForModel(Model model) {
		model.addAttribute("Header", "Coding with Tejas Tathe");
		model.addAttribute("Data", "Hiii from all Backend Devloupers...");
	}
	
	
	@RequestMapping("/info")
	String goToInfo() {
		System.out.println("These is info page");
		return "info_form";
	}

	// Way 1(Old) -

	/*
	 * @RequestMapping(path="/output",method = RequestMethod.POST) String
	 * handleFormRequest(HttpServletRequest request) { String email =
	 * request.getParameter("email"); String password =
	 * request.getParameter("pass"); String rollNumber =
	 * request.getParameter("rollno"); System.out.println("password = " + password +
	 * " RollNo = " + rollNumber + " Email = " + email); return "output"; }
	 */

	// Way 2 -rollNumber


	@RequestMapping(path = "/output", method = RequestMethod.POST)
	String handleFormRequest(@RequestParam("email") String userEmail,@RequestParam("pass") String userPassword, @RequestParam("rollno") String rollNumber, Model model) {
		
		User user = new User();
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		user.setRoll(rollNumber);
		
		System.out.println(user);
		this.userService.createUser(user);
		model.addAttribute("user",user);
		//model.addAttribute("userEmail", userEmail);
		//model.addAttribute("userPassword", userPassword);
		//model.addAttribute("rollNumber", rollNumber);
		return "output";
	}
	
	
	/*
	@RequestMapping(path = "/output", method = RequestMethod.POST)
	String handleFormRequest(@ModelAttribute User user, Model model) {
		System.out.println("request handled...");
		System.out.println(user);
		this.userService.createUser(user);
		return "output";
	}
	*/

}
