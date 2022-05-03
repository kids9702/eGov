package app.order.policy;

import app.member.Member;

public class NumberOfItemsPolicy implements ShippingFeePolicy {

	@Override
	public int calculateShippingFee(Member member, int itemCount) {
		// TODO Auto-generated method stub
		if(itemCount>=5) {
			return 0;
		}
		return 2500;
	}

}
