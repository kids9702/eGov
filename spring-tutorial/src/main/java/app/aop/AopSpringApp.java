package app.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import app.config.SpringAutoAppConfig;
import app.member.Member;
import app.member.service.MemberService;

public class AopSpringApp {

	public static void main(String[] args) throws Exception {
//		ApplicationContext ac = new GenericXmlApplicationContext("setting.xml");
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringAutoAppConfig.class);
		String [] names = ac.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println("name : " + name);
		}
		
		MemberService memberService = (MemberService) ac.getBean("memberServiceImpl");
		
		Member member = new Member();
		member.setId(1L);
		member.setName("aaa");
		
		memberService.join(member);
//		memberService.join(member);
		
		System.out.println("===================================");
		
		Member findMember = memberService.findMember(1L);
		System.out.println(findMember.getName());
		
//		Object proxy = ac.getBean("proxy");
//		System.out.println(proxy);
	}

}
