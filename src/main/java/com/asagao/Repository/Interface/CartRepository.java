package com.asagao.Repository.Interface;

import com.asagao.Domain.Cart;

public interface CartRepository {
	Cart[] findAll(int userId);
	
	
	
	
	
	
	
	
	
	int delete(int userId);

	void addToCart(Cart cart);
	Cart countByProductId(Cart cart);
	void update(Cart cart);
}
