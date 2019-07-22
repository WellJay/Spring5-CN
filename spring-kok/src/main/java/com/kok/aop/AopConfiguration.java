package com.kok.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author wenjie
 * @description
 * @time 2019/7/1 0001 13:18
 */
@Component
@Aspect
public class AopConfiguration {

	@Pointcut("execution(* com.kok.service..*.*(..))")
	private void anyOldTransfer() {}


	@Before("anyOldTransfer()")
	public void before(){
		System.out.println("before print...");
	}

	@After("anyOldTransfer()")
	public void after(){
		System.out.println("after print...");
	}

	/**
	 * Around advice is often used if you need to share state before and after a method execution in a thread-safe manner (starting and stopping a timer, for example).
	 * 前后共享状态
	 * @param pjp
	 * @throws Throwable
	 */
	@Around("anyOldTransfer()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(111);
		pjp.proceed();
		System.out.println(222);
	}
}
