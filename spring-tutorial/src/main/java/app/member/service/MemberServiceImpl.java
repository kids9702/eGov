package app.member.service;

import app.member.Member;
import app.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {
	
//	private MemberRepository memberRepository = new MemoryMemberRepository();
	
	private String prefix;
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	private MemberRepository memberRepository;
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
	}
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

	@Override
	public void join(Member member) throws Exception{
		// 1. id 확인
		Long memberId = member.getId();
		if(memberId == null) {
			throw new Exception();
		}
		
		// 2. 중복 확인
		Member storedMember = memberRepository.findById(memberId);
		if(storedMember != null) {
			throw new RuntimeException();
		}
		
		memberRepository.join(member);
	}

	@Override
	public Member findMember(Long memberId) throws Exception{
		return memberRepository.findById(memberId);
	}

}
