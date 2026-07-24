package com.asagao.Repository.Interface;

import java.util.List;

import com.asagao.Domain.OrderDetail;

public interface OrderDetailRepository {
	int create(OrderDetail orderDetail);
	List<OrderDetail> getOderDetails(int orderId);
}
