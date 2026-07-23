package com.asagao.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Order;

@Mapper
public interface OrderMapper{
	int create(Order order);
	
	List<Order> getOrders(int userId);
}
