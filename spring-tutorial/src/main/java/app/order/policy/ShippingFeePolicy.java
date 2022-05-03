package app.order.policy;

import app.member.Member;

public interface ShippingFeePolicy {
	int calculateShippingFee(Member member, int itemCount);
}
