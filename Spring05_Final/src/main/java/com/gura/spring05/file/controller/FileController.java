package com.gura.spring05.file.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.file.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService service;
	
	//파일 업로드 요청처리
	@RequestMapping("/file/private/upload")
	public ModelAndView upload(ModelAndView mView) {
		
		mView.setViewName("file/private/upload");
		return mView;
	}
	
	//파일 업로드 폼 요청처리
	@RequestMapping("/file/private/upload_form")
	public String uploadForm() {
		
		return "file/private/upload_form";
	}
	
	//파일 목록 요청처리
	@RequestMapping("/file/list")
	public ModelAndView list(ModelAndView mView,
			HttpServletRequest request) {
		
		service.getListLogic(mView, request);
		mView.setViewName("file/list");
		return mView;
	}
	
	//파일 업로드 요청 처리
	@RequestMapping(value = "/file/private/upload", 
			method = RequestMethod.POST)
	public String insert(FileDto dto, HttpSession session) {
		//글작성자는 세션에서 얻어내서
		String id=(String)session.getAttribute("id");
		//dto 에 담는다 
		dto.setWriter(id);
		//서비스를 통해서 파일을 DB 에저장
		service.uploadLogic(dto);
		
		return "file/private/upload";
	}
}
