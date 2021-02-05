package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
	@Around("execution(void sendEmail(java.lang.String))")
	public void emailConcern(ProceedingJoinPoint joinPoint ) throws Throwable {
		//aspect가 적용된 메소드가 수행되기 이전에 작업할 내용
		System.out.println("웹브라우저를 실행해요");
		
		//aspect가 적용된 메소드 호출해서 수행하기
		joinPoint.proceed();
		
		//aspect가 적용된 메소드가 직후 작업할 내용
		System.out.println("웹브라우저를 닫아요");
	}
	@Around("execution(void sendGreet(String))")
	public void greetConcern(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		 * 메소드에 전달되는 인자의 갯수는 1개
		 * 메소드에 전달되는 인자의 type은 String
		 * jointPoint.getArgs()는 Object[] type을 리턴한다.
		 * Object[] 에 0번방에 전달된 인자가 Object type으로 들어있다.
		 * 
		 */
		Object[] args=joinPoint.getArgs();
		//인자로 전달된 String type의 참조값 얻어내기
		String greet=(String)args[0];
		//만일 인사말에 "바보" 또는 "똥깨" 가 포함 되어 있다면
		if(greet.contains("바보")||greet.contains("똥깨")) {
			return; //메소드를 여기서 종료 (따라서 아래의 .proceed()가 호출 되지 않는다.)
		}
		
		joinPoint.proceed();
	}
	
	@Around("execution(String get*())")
	public Object getConcern(ProceedingJoinPoint joinPoint) throws Throwable {
		// aspect가 적용된 메소드가 리턴한 데이터의 참조값이 있다.
		Object obj=joinPoint.proceed();
		//원래 type으로 casting
		String returnedData=(String)obj;
		System.out.println("returnedData:"+returnedData);
		// aspect 에서 조건부로 다른 data를 리턴할 여지도 있다.
		String myData="맛있는 점심 되세요!";
		return myData;
	}
	
}
