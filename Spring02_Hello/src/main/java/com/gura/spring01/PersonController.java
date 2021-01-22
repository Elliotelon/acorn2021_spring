package com.gura.spring01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// component scan 될때 PersonController 객체가 생성이되고 관리가 된다. 
@Controller
public class PersonController {
	@RequestMapping("/person") //.do 생략가능
	public String person(HttpServletRequest request) {
		//view page 에 전달할 data (Model)
		String personToday="김구라";
		//request scope에 담는다.
		request.setAttribute("personToday", personToday);
		
		//forward 이동할 view page 의 위치를 리턴해준다.
		return "person"; // /WEB-INF/view/person.jsp
	}
}
