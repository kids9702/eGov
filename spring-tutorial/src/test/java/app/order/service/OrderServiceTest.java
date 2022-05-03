package app.order.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.config.AppConfig;
import app.member.Member;
import app.member.repository.MemberRepository;
import app.member.repository.MemoryMemberRepository;
import app.member.service.MemberService;
import app.member.service.MemberServiceImpl;
import app.order.Order;
import app.order.policy.NumberOfItemsPolicy;
import app.order.policy.ShippingFeePolicy;
import app.order.policy.TotalNumberPolicy;
import app.order.policy.TotalPricePolicy;

public class OrderServiceTest {
	
	AppConfig appConfig = new AppConfig();
	
	MemberRepository memberRepository = appConfig.memberRepository();
	
	@Test
	@DisplayName("기본 배송료 2500원 테스트")
	void test1() throws Exception {
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		member.setTotalCount(0);
		member.setTotalPrice(0);
		memberRepository.join(member);
		
		
		OrderService orderService = appConfig.orderService();
		
		Order order = orderService.createOrder(member.getId(), "itemA", 1000, 1000);
		
		Assertions.assertEquals(2500, order.getShippingFee());
		
		Order order2 = orderService.createOrder(member.getId(), "itemB", 100, 1);
		
		Assertions.assertEquals(0, order2.getShippingFee());
	}
	
	@Test
	@DisplayName("누적 주문금액 100만원 무료배송 테스트")
	void test2() throws Exception {
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		member.setTotalCount(0);
		member.setTotalPrice(0);
		
		memberRepository.join(member);
		
//		OrderService orderService = appConfig.orderService();
		
		OrderService orderService = new OrderServiceImpl(memberRepository, new TotalPricePolicy());
		
		Order order = orderService.createOrder(member.getId(), "itemA", 100000, 10);
		
		Assertions.assertEquals(2500, order.getShippingFee());
		
		Order order2 = orderService.createOrder(member.getId(), "itemB", 100, 5);
		
		Assertions.assertEquals(0, order2.getShippingFee());
	}
	
	@Test
	@DisplayName("1회 5개 구매시 무료배송 테스트")
	void test3() throws Exception {
		Member member = new Member();
		member.setId(1L);
		member.setName("memberA");
		member.setTotalCount(0);
		member.setTotalPrice(0);
		
		memberRepository.join(member);
		
		OrderService orderService = new OrderServiceImpl(memberRepository, new NumberOfItemsPolicy());
		
		Order order = orderService.createOrder(member.getId(), "itemA", 1000, 10);
		
		Assertions.assertEquals(0, order.getShippingFee());
		
		
	}
}
