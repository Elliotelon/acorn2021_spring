package com.gura.spring04.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring04.member.dao.MemberDao;
import com.gura.spring04.member.dto.MemberDto;

@Controller("api")
public class MemberController {
	
	@Autowired
	MemberDao dao;
	
	//회원목록을 [{},{},{}] 형식의 JSON 문자열로 응답하기
	@ResponseBody
	@RequestMapping("/api/member/list")
	public List<MemberDto> getList(){
		
		return dao.getList();
	}
	
	//회원 한명의 정보를 {} 형식의 JSON 문자열로 응답하기
	@ResponseBody
	@RequestMapping("/api/member/detail")
	public MemberDto getData(@RequestParam int num) {
		
		return dao.getData(num);
	}
	
	// 전송되는 이름과, 주소를 MemberDto에 받아서 DB에 저장하고
	// {"isSuccess":true} 형식의 JSON 문자열을 응답하는 메소드
	@ResponseBody
	@RequestMapping("/api/member/insert")
	public Map<String, Object> insert(@ModelAttribute MemberDto dto){
		dao.insert(dto);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
	}
	
	//전송되는 번호를 이용해서 해당 회원을 DB에서 삭제하고
	//{"isSuccess":true} 형식의 JSON 문자열을 응답하는 메소드
	@ResponseBody
	@RequestMapping("/api/member/delete")
	public Map<String, Object> delete(@RequestParam int num){
		dao.delete(num);;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
	}
	
	//전송되는 번호, 이름, 주소를 이용해서 해당정보를 DB에서 수정하고
	//{"isSuccess":true} 형식의 JSON 문자열을 응답하는 메소드
	@ResponseBody
	@RequestMapping("/api/member/update")
	public Map<String, Object> update(@ModelAttribute MemberDto dto){
		dao.update(dto);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
	}
	
}
