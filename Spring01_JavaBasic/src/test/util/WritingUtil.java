package test.util;

import org.springframework.stereotype.Component;

@Component
public class WritingUtil {
	public void write1() {
		System.out.println("편지를 써요");
	}
	public void write2() {
		System.out.println("보고서를 써요");
	}
	public void write3() {
		System.out.println("일기를 써요");
	}
	public void sendEmail(String address) {
		System.out.println(address+" 로 이메일을 보내요!");
	}
	public void sendGreet(String greet) {
		System.out.println(greet+" 라는 인사말을 보내요!");
	}
	public String getGreet() {
		return "맛점 하세요";
	}
	
}
