package app;

import app.member.Member;
import app.member.repository.MemoryMemberRepository;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		
		MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
		memoryMemberRepository.join(member);
		
		Member storedMember = memoryMemberRepository.findById(1L);
		System.out.println("member name is " + storedMember.getName());
		
	}

}
