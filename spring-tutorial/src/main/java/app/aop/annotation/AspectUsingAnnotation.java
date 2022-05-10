package app.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectUsingAnnotation {
	
	@Around(value = "execution(* app.member.service.MemberServiceImpl.join(..))")
	public Object doLog(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("*** Around 로직 시작 ***");
		
		Object result = joinpoint.proceed();
		
		System.out.println("*** Around 로직 종료 ***");
		return result;
	}
}
