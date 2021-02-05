package test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.WritingUtil;

public class MainClass4 {
	public static void main(String[] args) {
		// init.xml 문서를 로딩한다. (spring bean container 를 만든다.)
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/aop/init.xml");
		//spring bean container 에서 WritingUtil type의 참조값 얻어오기
		WritingUtil util=context.getBean(WritingUtil.class);
		
		String result=util.getGreet();
		System.out.println("result:"+result);
		
		System.out.println("main 메소드가 종료 됩니다.");
	
	}
}
