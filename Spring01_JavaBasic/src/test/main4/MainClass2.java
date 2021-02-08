package test.main4;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass2 {
	public static void main(String[] args) {
		//회원 가입할때 폼에 입력했던 비밀번호라고 가정
		String pwd="abcd1234";
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//인코딩해서 DB에 저장된 비밀번호라고 가정
		String savedPwd=encoder.encode(pwd);
		
		System.out.println("로그인 비밀번호 입력:");
		//로그인 할때 입력한 비밀번호라고 가정
		String inputPwd=new Scanner(System.in).nextLine();
		
		//DB에 저장된 비밀번호와 입력한 비밀번호가 일치하는지 여부
		boolean isEqual=BCrypt.checkpw(inputPwd, savedPwd);
		if(isEqual) {
			System.out.println("비밀번호가 일치해요!");
		}else {
			System.out.println("비밀번호가 달라요!");
		}
		
		
	}
}
