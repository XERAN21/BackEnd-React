package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Cart;

@Mapper
public interface CartMapper {
	Cart[] findAll(int userId);
	
	void addToCart(Cart cart);
}
