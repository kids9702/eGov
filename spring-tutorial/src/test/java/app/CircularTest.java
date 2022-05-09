package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.SpringAutoAppConfig;
import app.order.service.OrderServiceImpl;

public class CircularTest {
	
	@Test
	@DisplayName("순환참조 테스트")
	void test1() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringAutoAppConfig.class);
		
		CircularA circularA = (CircularA) ac.getBean("circularA");
		System.out.println(circularA);
//		circularA.run();
	}
}
