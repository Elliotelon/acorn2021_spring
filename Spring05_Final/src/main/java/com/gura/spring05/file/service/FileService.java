package com.gura.spring05.file.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;

public interface FileService {
	//파일 정보 저장
	public void uploadLogic(ModelAndView mView, HttpServletRequest request);
	//파일 정보 삭제
	public void deleteLogic(int num);
	//파일 하나의 정보를 리턴하는 메소드
	public FileDto getDataLogic(int num);
	//글 목록 얻어오기 (페이징 처리와 검색 키워드를 고려한 목록)
	public void getListLogic(ModelAndView mView, HttpServletRequest request);
	//글의 갯수 얻어오기(검색 키워드에 해당하는 갯수)
	public int getCountLogic(FileDto dto);
}
