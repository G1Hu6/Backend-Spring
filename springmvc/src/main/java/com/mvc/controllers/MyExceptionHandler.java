package com.mvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// Used for centralized Exception Handling
@ControllerAdvice
public class MyExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerExceptionHandler(Model model) {
		model.addAttribute("message","Null Pointer Exception Occored");
		return "error_page";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NumberFormatException.class)
	public String numberFormatExceptionHandler(Model model) {
		model.addAttribute("message","Number Format Exception Occored");
		return "error_page";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value =Exception.class)
	public String exceptionHandler(Model model) {
		model.addAttribute("message","Something went Wrong... Try again!!!");
		return "error_page";
	}
}
