package com.mvc.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/books/{bookId}/{bookName}")
	public String getBookMyId(@PathVariable("bookId") long id, @PathVariable("bookName") String bookName) {
		System.out.println(id);
		System.out.println(bookName);
		Integer.parseInt(bookName);  // Testing for NumberFormatException Handler
		return "output";
	}
	
	@RequestMapping("/home")
	public String goToHome(Model model) {
		
		System.out.println("These is home url");
		/*
		String str = null;
		System.out.println(str.length());  // Testing for NullPointerException Handler
		*/
		
		/*
		 we can send data to view with help of org.springframework.ui.Model() class and ModelAndView()
		 class. by setting key and value in addAttribute() method
		*/
		model.addAttribute("name","Pranav Patil");
		model.addAttribute("id", 12345);
		ArrayList<String> cartList = new ArrayList<String>();
		cartList.add("Burger");
		cartList.add("Pizza");
		cartList.add("Vada-Pav");
		cartList.add("Dosa");
		model.addAttribute("cart", cartList);
		return "index";
	}

	@RequestMapping("/about")
	public String goToAbout() {
		
		System.out.println("These is about url");
		return "about";
	}
	
	@RequestMapping("/help")
	public ModelAndView goToHelp() {
		
		System.out.println("These is help url");
		
		ModelAndView mv = new ModelAndView();
		// these is used to send data to view
		mv.addObject("name" , "Tathe Badam Themba");
		mv.addObject("rollnumber" , 69);
		mv.addObject("date", LocalDateTime.now());
		
		// these method is used to set view name
		mv.setViewName("help");
		List<Integer> marksList = new ArrayList<Integer>();
		marksList.add(11);
		marksList.add(22);
		marksList.add(33);
		marksList.add(44);
		marksList.add(55);
		mv.addObject("marks",marksList);
		return mv;
	}
	
	// Exception handling in Spring-Mvc
	
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = NullPointerException.class)
//	public String nullPointerExceptionHandler(Model model) {
//		model.addAttribute("message","Null Pointer Exception Occored");
//		return "error_page";
//	}
//	
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = NumberFormatException.class)
//	public String numberFormatExceptionHandler(Model model) {
//		model.addAttribute("message","Number Format Exception Occored");
//		return "error_page";
//	}
//	
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value =Exception.class)
//	public String exceptionHandler(Model model) {
//		model.addAttribute("message","Something went Wrong... Try again!!!");
//		return "error_page";
//	}
}
