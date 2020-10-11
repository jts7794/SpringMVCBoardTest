package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	/**
	@ExceptionHandler(Exception.class)
	public String common(Exception e) {
		
		logger.info(e.toString());
		
		return "error_common";
	}
	*/
	
	/** 
	 * ModelAndView객체 
	 * 하나의 객체에 Model 데이터와 View의 처리를 동시에 할 수 있는 객체 
	 * 메소드 errorModelAndView()에서 내부적으로 ModelAndView객체를 생성하고 반환
	 * */
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex) {
		
		logger.info("CommonException Start");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", ex);
		
		logger.info("CommonException End");
		
		return modelAndView;
	}
	
}
