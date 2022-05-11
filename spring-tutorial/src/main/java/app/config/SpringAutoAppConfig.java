package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

import app.member.service.MemberService;
import app.member.service.MemberServiceImpl;

@Configuration
@ComponentScan(
		basePackages = {"app"},
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		)
@EnableAspectJAutoProxy
public class SpringAutoAppConfig {
	
	@Bean
	public MemberService memberServiceImpl() {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		memberServiceImpl.setPrefix("수동등록");
		
		return memberServiceImpl;
	}
}