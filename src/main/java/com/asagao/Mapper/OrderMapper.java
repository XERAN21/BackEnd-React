package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD
@Mapper
public interface OrderMapper {

=======
import com.asagao.Domain.Order;

@Mapper
public interface OrderMapper {
	int create(Order order);
}
