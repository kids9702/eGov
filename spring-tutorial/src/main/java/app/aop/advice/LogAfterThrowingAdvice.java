package app.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice{
	
	public void afterThrowing(Exception e) throws Throwable {
		System.out.println("### Exception 발생 ###");
	}
	
	public void afterThrowing(RuntimeException e) throws Throwable {
		System.out.println("### RuntimeException 발생 ###");
	}
}
