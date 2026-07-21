package com.asagao.Repository.DB;

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

}
