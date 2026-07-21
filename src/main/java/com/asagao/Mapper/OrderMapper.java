package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Order;

@Mapper
public interface OrderMapper {
	int create(Order order);
}
