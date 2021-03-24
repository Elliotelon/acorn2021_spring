package com.gura.spring05.gallery.dao;

import java.util.List;

import com.gura.spring05.gallery.dto.GalleryDto;

public interface GalleryDao {
	public GalleryDto getData(int num);
	public void insert(GalleryDto dto);
	public List<GalleryDto> getList(GalleryDto dto);
	public int getCount();
	//안드로이드 앱 테스트를 위한 메소드
	public List<GalleryDto> getListAll();
}


