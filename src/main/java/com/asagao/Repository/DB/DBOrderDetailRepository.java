package com.asagao.Repository.DB;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.OrderDetail;
import com.asagao.Mapper.OrderDetailMapper;
import com.asagao.Repository.Interface.OrderDetailRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBOrderDetailRepository implements OrderDetailRepository {

	private final  OrderDetailMapper orderDetailMapper;
	
	@Override
	public int create(OrderDetail orderDetail) {
		return orderDetailMapper.create(orderDetail);
	}

	@Override
	public List<OrderDetail> getOderDetails(int orderId) {
		return orderDetailMapper.getOderDetails(orderId);
	}

}
