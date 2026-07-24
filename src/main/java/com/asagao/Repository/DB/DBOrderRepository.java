package com.asagao.Repository.DB;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.Order;
import com.asagao.Mapper.OrderMapper;
import com.asagao.Repository.Interface.OrderRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBOrderRepository implements OrderRepository {

	private final OrderMapper orderMapper;
	
	@Override
	public int create(Order order) {
		return orderMapper.create(order);
	}

	@Override
	public List<Order> getOrders(int userId) {
		return orderMapper.getOrders(userId);
	}

	@Override
	public Order getOrder(int id) {
		return orderMapper.getOrder(id);
	}

}
