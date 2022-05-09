package app.order.policy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import app.member.Member;

@Component
@Qualifier("aaa")
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
