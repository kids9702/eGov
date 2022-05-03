package app.member.service;

import app.member.Member;
import app.member.repository.MemberRepository;
import app.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {
	
//	private MemberRepository memberRepository = new MemoryMemberRepository();
	
	private MemberRepository memberRepository;
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
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
