package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Cart;

@Mapper
public interface CartMapper {
	Cart[] findAll(int userId);
	
	void addToCart(Cart cart);
	
	Cart countByProductId(Cart cart);
	
	void update(Cart cart);
}
