package com.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		
		return "hello";
	}
	
	@RequestMapping("/welcome")
	public String helloGreating(@RequestParam("name") String name, Model model) {
		System.out.println(name);
		model.addAttribute("name", name);
		return "welcome";
	}
}
