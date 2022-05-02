package app.member.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.member.Member;
import app.member.repository.MemoryMemberRepository;

public class MemberServiceTest {
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Test
	@DisplayName("회원가입 테스트")
	void test1() throws Exception {
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		
		memberService.join(member);
		
		Member storedMember = memberService.findMember(1L);
		
		
		Assertions.assertEquals(member.getName(), storedMember.getName());
		
		//System.out.println("member name is " + storedMember.getName());
	}
	
	@Test
	@DisplayName("ID가 없는 경우")
	void test2() {
		Member member = new Member();
		member.setName("memberA");
		
		Assertions.assertThrows(Exception.class, () -> {
			memberService.join(member);
		});
	}
	
	@Test
	@DisplayName("ID가 중복인 경우는 RuntimeException 발생")
	void test3() {
		Long memberId = 1L;
		
		Member memberA = new Member();
		memberA.setId(memberId);
		memberA.setName("memberA");
		
		try {
			memberService.join(memberA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Member memberB = new Member();
		memberB.setId(memberId);
		memberB.setName("memberB");
		
		Assertions.assertThrows(RuntimeException.class, () -> {
			memberService.join(memberB);
		});
		
	}
}
