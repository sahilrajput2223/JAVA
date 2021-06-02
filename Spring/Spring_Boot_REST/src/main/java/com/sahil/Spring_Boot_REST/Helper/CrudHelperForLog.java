package com.sahil.Spring_Boot_REST.Helper;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


import lombok.extern.log4j.Log4j;

@Component
@Aspect
@EnableAspectJAutoProxy
@Log4j
public class CrudHelperForLog {

	
	@Pointcut(value = "execution(* com.sahil.Spring_Boot_REST.*.*.*(..))")
	public void pointCutForLogger() {
		
	}
	
	
	@Around("pointCutForLogger()")
	public void applicationLoggerForController(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().toString(); 
		log.info("Method Called " + className + " : " + "Method Name" + " : " + methodName + "()");
		//Object object = joinPoint.proceed();
		log.info("Method Call Done " + className + " : " + "Method Name" + " : " + methodName + "()");
	}
	
	
	
//	@After("execution(* com.sahil.Spring_Boot_REST.controller.UserController.getAllUser())")
//	public void logForAllUser() {
//		log.info("All User API Request Called");
//	}
	
//	@Around("execution(* com.sahil.Spring_Boot_REST.controller.UserController.createUser()) && args(user,..)")
//	public void logForNewUserRequest(User user) {
//		log.info("New User Creation Request API Called for :: " + user.getUsername());
//	}
}
