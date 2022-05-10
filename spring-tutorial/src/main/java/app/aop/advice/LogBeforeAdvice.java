package app.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("### Before 로직 ###");
		System.out.println("method : " + method);
		
		for(Object arg : args) {
			System.out.println("arg : " + arg);
		}
		System.out.println("target : " + target);
	}

}
