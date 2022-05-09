package app.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import app.member.repository.MemberRepository;
import app.member.service.MemberServiceImpl;
import app.order.policy.ShippingFeePolicy;
import app.order.service.OrderServiceImpl;

public class SpringAutoAppConfigTest {
	
	@Test
	@DisplayName("annotation 기반으로 생성된 모든 Bean 조회")
	void test1() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringAutoAppConfig.class);
		String [] names = ac.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println("name : " + name);
		}
		
		MemberServiceImpl memberServiceImpl = (MemberServiceImpl) ac.getBean("memberServiceImpl");
		System.out.println(memberServiceImpl.getPrefix());
	}
//	
//	@Test
//	@DisplayName("DI 확인")
//	void test2() {
//		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringAutoAppConfig.class);
//		MemberRepository memberRepository = ac.getBean("memoryMemberRepository", MemberRepository.class);
//		MemberServiceImpl memberService = ac.getBean("memberServiceImpl", MemberServiceImpl.class);
//		
//		Assertions.assertEquals(memberService.getMemberRepository(), memberRepository);
//	}
//	
//	@Test
//	@DisplayName("xml 기반으로 생성된 모든 Bean 조회")
//	void test3() {
//		ApplicationContext ac = new GenericXmlApplicationContext("setting.xml");
//		String [] names = ac.getBeanDefinitionNames();
//		for(String name : names) {
//			System.out.println("xml : " + name);
//		}
//	}
	
//	@Test
//	@DisplayName("shippingFeePolicy 확인")
//	void test4() {
//		ApplicationContext ac = new GenericXmlApplicationContext("setting.xml");
//		
//		OrderServiceImpl orderServiceImpl = (OrderServiceImpl) ac.getBean("orderServiceImpl");
//		
//		
//		ShippingFeePolicy shippingFeePolicy = orderServiceImpl.getShippingFeePolicy();
//		
//		System.out.println(shippingFeePolicy);
//	}
}
