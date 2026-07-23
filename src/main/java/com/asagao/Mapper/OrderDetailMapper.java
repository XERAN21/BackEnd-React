package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.OrderDetail;

@Mapper
public interface OrderDetailMapper {
	int create(OrderDetail orderDetail);
	
	OrderDetail getOderDetails(int orderId);
}
