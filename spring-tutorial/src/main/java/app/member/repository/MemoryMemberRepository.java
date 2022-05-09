package app.member.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import app.member.Member;

@Component
public class MemoryMemberRepository implements MemberRepository {
	
	private Map<Long, Member> memberDb = new HashMap<>();
	
	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		memberDb.put(member.getId(), member);
	}

	@Override
	public Member findById(Long id) {
		// TODO Auto-generated method stub
		Member member = memberDb.get(id);
		return member;
		
	}

}
