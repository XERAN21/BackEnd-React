package com.asagao.Repository.Interface;

import com.asagao.Domain.Cart;

public interface CartRepository {
	Cart[] findAll(int userId);
	void addToCart(Cart cart);
}
