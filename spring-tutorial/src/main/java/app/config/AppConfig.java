package app.config;

import app.member.repository.MemberRepository;
import app.member.repository.MemoryMemberRepository;
import app.member.service.MemberService;
import app.member.service.MemberServiceImpl;
import app.order.policy.NumberOfItemsPolicy;
import app.order.policy.ShippingFeePolicy;
import app.order.policy.TotalPricePolicy;
import app.order.service.OrderService;
import app.order.service.OrderServiceImpl;

public class AppConfig {
	private MemberRepository memberRepository;
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), shippingFeePolicy());
	}
	
	public MemberRepository memberRepository() {
		if(memberRepository == null) {
			memberRepository = new MemoryMemberRepository();
		}
		return memberRepository;
	}
	
	public ShippingFeePolicy shippingFeePolicy() {
//		return new NumberOfItemsPolicy();
		return new TotalPricePolicy();
	}
}
