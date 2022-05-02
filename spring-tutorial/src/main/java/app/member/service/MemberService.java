package app.member.service;

import app.member.Member;

public interface MemberService {
	void join(Member member) throws Exception;
	Member findMember(Long memberId) throws Exception;
}
