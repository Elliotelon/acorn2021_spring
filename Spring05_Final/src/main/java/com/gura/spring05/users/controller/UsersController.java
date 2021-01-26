package com.gura.spring05.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gura.spring05.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}
	
	@RequestMapping("/users/checkid")
	public String checkId(HttpServletRequest req) {
		String inputId=req.getParameter("inputId");
		boolean isExistId=service.isExistId(inputId);
		req.setAttribute("isExistId", isExistId);
		return "users/checkid";
	}
}
