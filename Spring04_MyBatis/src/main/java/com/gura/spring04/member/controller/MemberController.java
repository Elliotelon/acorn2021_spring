package com.gura.spring04.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dao.MemberDao;

@Controller
public class MemberController {
	// MemberDao 인터페이스 type 을 주입(DI) 받아서 사용한다.
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/list.do")
	public ModelAndView list() {
		
		return null;
	}
}
