package app.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("### Around 로직 시작 ###");
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed();
		
		Thread.sleep(200);
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + " ms 걸림");
		
		System.out.println("### Around 로직 종료 ###");
		return result;
	}
	
}
