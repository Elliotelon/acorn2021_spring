package com.gura.spring05.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.users.dto.UsersDto;
import com.gura.spring05.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	//회원 가입 요청처리
	//form 전송은 보통 post 방식 요청인데 post 방식 요청만 받아들이도록
	//컨트롤러에 설정하는게 일반적이다.
	@RequestMapping(value="/users/signup", method=RequestMethod.POST )
	public String signup(@ModelAttribute("dto") UsersDto dto) {
		/*
		 * Dto인 경우에 @ModelAttribute("key 값") 으로 설정하면
		 * 해당 Dto 가 request 영역에 설정한 "key 값" 으로 닥민다.
		 * 
		 */
		service.addUser(dto);
		return "users/signup";
	}
	
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}
	//ajax 요청 처리
	@RequestMapping("/users/checkid")
	public ModelAndView checkid(@RequestParam String inputId,
			ModelAndView mView) {
		/*
		 * @RequestParam String inputId
		 * 는
		 * String inputId=request.getParameter("inputId")
		 * 
		 */
		//서비스를 이용해서 해당 아이디가 존재하는지 여부를 알아낸다.
		boolean isExist=service.isExistId(inputId);
		//ModelAndView 객체에 해당 정보를 담고 view page로 forward 이동해서 응답
		mView.addObject("isExist",isExist);
		mView.setViewName("users/checkid");
		return mView;
	}
}
