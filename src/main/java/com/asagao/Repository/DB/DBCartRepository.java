package com.asagao.Repository.DB;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.Cart;
import com.asagao.Mapper.CartMapper;
import com.asagao.Repository.Interface.CartRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBCartRepository implements CartRepository {

	private final CartMapper cartMapper;
	
	@Override
	public Cart[] findAll(int userId) {
		return cartMapper.findAll(userId);
	}
	
	@Override
	public void addToCart(Cart cart) {
		cartMapper.addToCart(cart);
		
	}

	@Override
	public Cart countByProductId(Cart cart) {
		return cartMapper.countByProductId(cart);
	}

	@Override
	public void update(Cart cart) {
		cartMapper.update(cart);
		
	}

}
