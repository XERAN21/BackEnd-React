package com.asagao.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.OrderDetail;

@Mapper
public interface OrderDetailMapper {
	int create(OrderDetail orderDetail);
	
	List<OrderDetail> getOderDetails(int orderId);
}
