package com.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

	@RequestMapping("/one")
	public String one() {
	
		System.out.println("page one");
		return "redirect:/enjoy";
	}
	
	@RequestMapping("/enjoy")
	public String two() {
		System.out.println("page enjoy");
		return "info_form";
	}
	
	@RequestMapping("/two")
	public RedirectView three() {
		System.out.println("page three");
		RedirectView reView = new RedirectView();
		reView.setUrl("enjoy");
		return reView;
	}
}
