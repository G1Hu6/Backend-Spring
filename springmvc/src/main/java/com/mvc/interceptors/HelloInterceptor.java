package com.mvc.interceptors;

import java.util.logging.Handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloInterceptor implements HandlerInterceptor {
	
	public boolean preHandler(HttpServletRequest request, HttpServletResponse response, Handler handle) {
		System.out.println("pre Handler method...");
		String name = (String)request.getAttribute("name");
		if(name == null || name.trim() == null || name.startsWith("a")) {
			return false;
		}
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		 ModelAndView modelAndView) throws Exception {
		System.out.println("post Handler method...");
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			 Exception ex) throws Exception {
		System.out.println("afterCompletion method...");
	}
}
