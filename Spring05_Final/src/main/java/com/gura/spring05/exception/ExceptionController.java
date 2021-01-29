package com.gura.spring05.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/* Spring Framework가 동작하는 중에 특정 예외가 발생하면 여기에서 직접 응답하고자 할때 사용한다.
 */

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(DBFailException.class)
	public ModelAndView dbFail(DBFailException e, ModelAndView mView) {
		//"exceptino" 이라는 키 값으로 예외객체의 참조값을 담고
		//담은 예외 객체는 view page 에서${exception.message} 형태로 사용한다.
		mView.addObject("exception",e);
		mView.setViewName("error/db_fail");
		return mView;
		
	}
	
}
