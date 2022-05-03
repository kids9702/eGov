package app.order.policy;

import app.member.Member;

public class TotalPricePolicy implements ShippingFeePolicy {

	@Override
	public int calculateShippingFee(Member member, int itemCount) {
		// TODO Auto-generated method stub
		if(member.getTotalPrice() >= 1000000) {
			return 0;
		};
		return 2500;
	}
}
