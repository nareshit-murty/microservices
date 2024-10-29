package com.nit.department.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class Logger {

	@Before(value = "execution(* com.nit.department..*(..))")
	public void beforeLogging(JoinPoint joinpoint) {
		log.info("Entered into : {}",joinpoint.toShortString());
	}
	
}
