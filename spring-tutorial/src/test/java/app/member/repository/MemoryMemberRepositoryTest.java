package app.member.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.member.Member;

public class MemoryMemberRepositoryTest {
	@Test
	void 회원가입및조회테스트() {
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.join(member);
		
		Member storedMember = memberRepository.findById(1L);
		
		Assertions.assertEquals(member.getName(), storedMember.getName());
		
		//System.out.println("member name is " + storedMember.getName());
	}
	
	@Test
	@DisplayName("테스트입니다")
	void test2() {
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.join(member);
		
		Member storedMember = memberRepository.findById(1L);
		
		Assertions.assertEquals("jaxking", storedMember.getName());
		
		//System.out.println("member name is " + storedMember.getName());
	}
}
