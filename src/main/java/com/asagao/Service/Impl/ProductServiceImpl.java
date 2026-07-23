package com.asagao.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asagao.Domain.Cart;
import com.asagao.Domain.Order;
import com.asagao.Domain.OrderDetail;
import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.CartRepository;
import com.asagao.Repository.Interface.OrderDetailRepository;
import com.asagao.Repository.Interface.OrderRepository;
import com.asagao.Repository.Interface.ProductRepository;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final OrderDetailRepository orderDetailRepository;
	private final CartRepository cartRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public void addToCart(Cart cart) {
		cartRepository.addToCart(cart);
	}

	@Override
	public Cart[] getCartItems(int userId) {
		return cartRepository.findAll(userId);
	}

	@Override
	public void clearCartItems(int userId) {
		cartRepository.delete(userId);
	}

	@Override
	@Transactional
	public int addOrder(Order order,Cart[] carts) {
		order.setCreatedAt(LocalDateTime.now());
		order.setUpdatedAt(LocalDateTime.now());
		int orderId = orderRepository.create(order);
		order.setId(orderId);

		for (Cart cart: carts) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(order.getId());  
			orderDetail.setProductId(cart.getProductId());
			orderDetail.setAmount(cart.getAmount());
			orderDetail.setCreatedAt(LocalDateTime.now());
			orderDetail.setUpdatedAt(LocalDateTime.now());
			orderDetailRepository.create(orderDetail);
		}
		return 1;
	}

}
