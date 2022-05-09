package app.order.policy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import app.member.Member;

@Component
@Primary
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
