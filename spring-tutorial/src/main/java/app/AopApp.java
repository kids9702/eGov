package app;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import app.member.Member;
import app.member.repository.MemoryMemberRepository;
import app.member.service.MemberService;
import app.member.service.MemberServiceImpl;

public class AopApp {

	public static void main(String[] args) {
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		
		MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
		MemberService proxy = (MemberService) Proxy.newProxyInstance(
				MemberServiceImpl.class.getClassLoader(),
				new Class[] {MemberService.class},
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long start = System.currentTimeMillis();
						
						Object obj = method.invoke(memberService, args);
						
						Thread.sleep(200);
						long end = System.currentTimeMillis();
						
						System.out.println(end - start + " ms 걸림");
						
						return obj;
					}
				});
		
		try {
			proxy.join(member);
			proxy.findMember(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
