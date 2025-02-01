package com.mvc.controllers;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import jakarta.servlet.http.HttpSession;

@Controller
public class FileUploadController {

	@RequestMapping("/file")
	public String showFileUploadForm() {
		return "fileupload_form";
	}

	@RequestMapping(path = "/fileupload", method = RequestMethod.POST)
	public String handleUploading(@RequestParam("profile") StandardServletMultipartResolver file, Model model, HttpSession session) throws MultipartException{
		System.out.println("Handle uploading");
		System.out.println(((MultipartFile) file).getContentType());
		System.out.println(((MultipartFile) file).getName());
		System.out.println(((MultipartFile) file).getOriginalFilename());
		System.out.println(((MultipartFile) file).getSize());
		
		
		return "success";
	}
}
