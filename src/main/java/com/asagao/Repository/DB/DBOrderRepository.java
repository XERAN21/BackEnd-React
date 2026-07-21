package com.asagao.Repository.DB;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.Order;
import com.asagao.Repository.Interface.OrderRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBOrderRepository implements OrderRepository {

	private final OrderRepository orderRepository;
	
	@Override
	public int create(Order order) {
		return orderRepository.create(order);
	}

}
