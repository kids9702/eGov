package app.order.policy;

import app.member.Member;

public class TotalNumberPolicy implements ShippingFeePolicy{

	@Override
	public int calculateShippingFee(Member member, int itemCount) {
		// TODO Auto-generated method stub
		if(member.getTotalCount() >= 1000) {
			return 0;
		};
		return 2500;
	}
}
