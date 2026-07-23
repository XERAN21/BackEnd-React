package com.asagao.Service.Interface;


import java.util.List;

import com.asagao.Domain.Cart;
import com.asagao.Domain.Order;
import com.asagao.Domain.Product;

public interface ProductService {

	public List<Product> getProducts();

	Product getById(int id);

	
	void addToCart(Cart cart);



	int addOrder(Order order,Cart[] carts);
	

	Cart[] getCartItems(int userId);

	void clearCartItems(int userId);

}
