package com.sahil.SpringProjectLombok.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {

	@Pointcut("execution(* com.sahil.SpringProjectLombok.controller.*.*(..))")
	private void pointCutForController() {
	}
	
	@Before("pointCutForController()")
	public void before(JoinPoint joinpoint) {
		log.info("Before method execution {}", joinpoint.getSignature().getName());
	}
	
	@AfterReturning(value = "pointCutForController()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		log.info("{} returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing(value = "pointCutForController()", throwing = "e")
	public void afterThrowingException(JoinPoint joinPoint, Throwable e) {
		log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}
	
	@After(value = "pointCutForController()")
	public void after(JoinPoint joinPoint) {
		log.info("after execution of {}", joinPoint);
	}
	
	
	@Around(value = "pointCutForController()")
	public Object profileAllMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		
		final StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();
		
		log.info("Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");
		return result;

	}

}
