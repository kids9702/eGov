package app.member.service;

import app.member.Member;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;


public interface MemberService {
	void join(Member member) throws Exception;
	Member findMember(Long memberId) throws Exception;
}
