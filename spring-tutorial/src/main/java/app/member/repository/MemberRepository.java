package app.member.repository;

import app.member.Member;

public interface MemberRepository {
	void join(Member member);
	Member findById(Long id);
	
}
