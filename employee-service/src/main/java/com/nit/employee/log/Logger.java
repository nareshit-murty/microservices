package com.nit.employee.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class Logger {
	
	@Before(value="execution(* com.nit.employee..*(..))")
	public void beforeEnter(JoinPoint joinPoint) {
		log.info("Entered into : {}", joinPoint.toShortString());
		log.info("Parameters count is : {}", joinPoint.getArgs().length);
		for(Object obj : joinPoint.getArgs())
			log.info("Parameters are : {}", obj);
	}
}
