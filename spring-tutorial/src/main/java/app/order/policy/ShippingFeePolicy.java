package app.order.policy;

import org.springframework.stereotype.Component;

import app.member.Member;

@Component
public interface ShippingFeePolicy {
	int calculateShippingFee(Member member, int itemCount);
}
