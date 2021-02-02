package com.gura.spring05.file.dao;

import java.util.List;
import com.gura.spring05.file.dto.FileDto;

public interface FileDao {
	//업로드된 파일 정보를 저장하는 메소드
	public void upload(FileDto dto);
	//파일 정보를 삭제하는 메소드
	public void delete(int num);
	//파일 하나의 정보를 리턴하는 메소드
	public FileDto getData(int num);
	//글 목록 얻어오기 (페이징 처리와 검색 키워드를 고려한 목록)
	public List<FileDto> getList(FileDto dto);
	//글의 갯수 얻어오기(검색 키워드에 해당하는 갯수)
	public int getCount(FileDto dto);
	
}
