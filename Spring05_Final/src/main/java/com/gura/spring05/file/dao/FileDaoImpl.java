package com.gura.spring05.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gura.spring05.file.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public void upload(FileDto dto) {
		session.insert("file.insert", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("file.delete", num);
	}

	@Override
	public FileDto getData(int num) {
		return session.selectOne("file.getData", num);
	}

	@Override
	public List<FileDto> getList(FileDto dto) {
		List<FileDto> list=session.selectList("file.getList",dto);
		return list;
	}

	@Override
	public int getCount(FileDto dto) {
		int count=session.selectOne("file.getCount", dto);
		return count;
	}
}
