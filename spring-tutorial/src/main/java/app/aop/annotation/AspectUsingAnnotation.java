package app.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUsingAnnotation {
	
	@Pointcut("execution(* app.member.service.MemberServiceImpl.join(..))")
	private void join() {}
	@Pointcut("execution(* app.member.service.MemberServiceImpl.findMember(..))")
	private void findMember() {}
	
	@Around(value = "join()")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("*** Around 로직 시작 ***");
		
		Object result = joinPoint.proceed();
		
		System.out.println("*** Around 로직 종료 ***");
		return result;
	}
	@Before(value = "join()")
	public void doBefore(JoinPoint joinpoint) {
		System.out.println("*** Before 로직 ***");
	}
	@AfterReturning(value = "findMember()", returning = "result")
	public void doReturn(JoinPoint joinPoint, Object result) {
		System.out.println("*** AfterReturning 로직 시작 ***");
		System.out.println("Result : " + result);
		System.out.println("*** AfterReturning 로직 종료 ***");
	}
	@AfterThrowing(value = "join()", throwing = "exception")
	public void doThrow(JoinPoint joinPoint, Exception exception) {
		System.out.println("*** After Throwing 로직***");
		
	}
	@After(value = "join()")
	public void doAfter() {
		System.out.println("*** After 로직 ***");
	}
}
