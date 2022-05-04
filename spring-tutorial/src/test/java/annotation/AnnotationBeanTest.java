package annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import app.config.SpringAppConfig;
import app.member.service.MemberService;
import app.member.service.MemberServiceImpl;

public class AnnotationBeanTest {
	
	ApplicationContext ac;
	
	@BeforeEach
	void before() {
		ac = new AnnotationConfigApplicationContext(SpringAppConfig.class);
	}
	
	@Test
	@DisplayName("annotaiton 기반으로 생성된 모든 Bean 조회")
	void test1() {
		String[] names = ac.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println("Bean name : " + name);
		}
	}
	@Test
	@DisplayName("중복된 이름이 있는 경우 오류가 발생할 수 있다")
	void test2() {
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		System.out.println("prefix : " + memberService.getPrefix());
	}
}
