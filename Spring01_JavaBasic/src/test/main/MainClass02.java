package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		//init.xml 문서를 로딩해서 Spring 이 생성할 객체는 생성해서 관리 하게 하기
		ApplicationContext context=new ClassPathXmlApplicationContext("test/main/init.xml");
		
		/*
		 * Spring 이 관리하는 객체 중에 id 가 myWeapon 인 객체의 참조값을
		 * Object type 으로 리턴받아서
		 * Weapon 인터페이스 type 으로 casting 해서
		 * w라는 이름의 지역변수에 참조값을 담기 
		 */
		Weapon w=(Weapon)context.getBean("myWeapon");
		w.attack();
	}
}
