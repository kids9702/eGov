package app.member;

import app.order.Order;

public class Member {
	private Long id;
	private String name;
	private int totalCount;
	private int totalPrice;
	
	public void makeOrder(Order order) {
		if(id.equals(order.getMemberId())) {
			totalCount += order.getItemCount();
			totalPrice += order.getItemCount() * order.getItemPrice() + order.getShippingFee();
		}
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
