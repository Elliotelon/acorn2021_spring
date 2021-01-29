package com.gura.spring05.cafe.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService service;
	
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num) {
		service.deleteContent(num);
		return "cafe/private/delete";
	}
	
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView updateform(@RequestParam int num,
			ModelAndView mView) {
		service.getDetail(num, mView);
		mView.setViewName("cafe/private/updateform");
		return mView;
	}
	
	@RequestMapping(value="/cafe/private/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("dto") CafeDto dto) {
		service.updateContent(dto);
		return "cafe/private/update";
	}
	
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(@RequestParam int num, ModelAndView mView) {
		//자세히 보여줄 글번호가 파라미터로 넘어온다.
		service.getDetail(num, mView);
		//view page로 forward 이동해서 응답.
		mView.setViewName("cafe/detail");
		return mView;
	}
	//글 목록 요청 처리
	@RequestMapping("/cafe/list")
	public ModelAndView list(ModelAndView mView,
			HttpServletRequest request) {
		service.getList(mView, request);
		mView.setViewName("cafe/list");
		return mView;
	}
	
	//카페 새글 저장 요청 처리
	@RequestMapping(value="/cafe/private/insert",
		method=RequestMethod.POST)
	public String insert(CafeDto dto, HttpSession session) {
		//글작성자는 세션에서 얻어내서
		String id=(String)session.getAttribute("id");
		//dto에 담는다
		dto.setWriter(id);
		service.saveContent(dto);
		
		return "cafe/private/insert";
	}
	//카페 새 글쓰기 요청 처리
	@RequestMapping("/cafe/private/insertform")
	public String insertform() {
		
		// /WEB-INF/views/  cafe/private/inserform     .jsp
		return "cafe/private/insertform";
	}
}
