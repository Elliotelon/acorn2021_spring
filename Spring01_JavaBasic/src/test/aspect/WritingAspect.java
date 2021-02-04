package test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * Aspect : 공통 관심사 (횡단 관심사 cross concern)
 * 
 * - 핵심 비즈니스 로직과는 상관 없는 공통 관심사를 따로 작성한다.
 */
@Aspect //aspect 역할을 할 수 있도록 필요한 어노테이션
@Component // component scan을 통해서 bean이 될 수 있도록
public class WritingAspect {
	
	@Before("execution(void write*())") // @Before( ) : ()안에 aspectj expression 문법에 맞게 작성해주어야함.
	public void prepare() {
		System.out.println("pen을 준비해요");
	}
	@After("execution(void write*())")
	public void finish() {
		System.out.println("pen을 다시 정리해요");
	}
}
