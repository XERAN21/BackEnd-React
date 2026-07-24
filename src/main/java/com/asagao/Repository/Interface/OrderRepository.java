package com.asagao.Repository.Interface;

import java.util.List;

import com.asagao.Domain.Order;

public interface OrderRepository {
	int create(Order order);
	List<Order> getOrders(int userId);
	Order getOrder(int id);
}
