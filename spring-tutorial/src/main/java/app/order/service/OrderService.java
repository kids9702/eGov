package app.order.service;

import app.order.Order;

public interface OrderService {
	Order createOrder(Long memberId, String itemName, int itemPrice, int itemCount);
}
