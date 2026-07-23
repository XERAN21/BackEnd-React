package com.asagao.Service.Interface;

import java.util.List;

import com.asagao.Domain.Cart;
import com.asagao.Domain.Order;
import com.asagao.Domain.OrderDetail;
import com.asagao.Domain.Product;

public interface ProductService {

	public List<Product> getProducts();

	Product getById(int id);

	void addToCart(Cart cart);

	int addOrder(Order order, Cart[] carts);

	Cart[] getCartItems(int userId);

	Cart countByProductId(Cart cart);

	void update(Cart cart);

	void clearCartItems(int userId);

	void deleteCartByCartId(int id);

	Cart getCartById(int id);
	
	List<OrderDetail> getOderDetails(int orderId);
	
	List<Order> getOrders(int userId);
	
	Order getOrder(int id);

}
