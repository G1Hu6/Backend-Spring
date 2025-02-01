package com.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("find")
	public String find() {
		
		System.out.println("find page is running");
		return "search";
	}
	
	@RequestMapping("search")
	public RedirectView search(@RequestParam("querybox") String query) {
		RedirectView reView = new RedirectView();
		if(query.trim() == "") {
			reView.setUrl("find");
			return reView;
		}
		
		String value = "https://www.google.com/search?q=" + query.trim(); 
		reView.setUrl(value);
		return reView;
	}
}
