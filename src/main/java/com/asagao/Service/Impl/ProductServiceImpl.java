package com.asagao.Service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final OrderDetailRepository orderDetailRepository;
	private final CartRepository cartRepository;

	@Override
	public List<Product> findAll(String name, String colorId) {
		return productRepository.findAll(name, colorId);
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
	public Cart countByProductId(Cart cart) {
		return cartRepository.countByProductId(cart);
	}

	@Override
	public void update(Cart cart) {
		cartRepository.update(cart);
	}

	public void clearCartItems(int userId) {
		cartRepository.delete(userId);
	}

	@Override
	@Transactional
	public int addOrder(Order order, Cart[] carts) {
		order.setCreatedAt(LocalDateTime.now());
		order.setUpdatedAt(LocalDateTime.now());
		orderRepository.create(order);
		System.out.println(order.getSumPrice());

		for (Cart cart : carts) {
			OrderDetail orderDetail = new OrderDetail();
			Product product = productRepository.findById(cart.getProductId());
			orderDetail.setOrderId(order.getId());
			orderDetail.setProductId(cart.getProductId());
			orderDetail.setProductName(product.getName());
			orderDetail.setProductPrice(product.getPrice());
			orderDetail.setProductImage_url(product.getImage_url());
			orderDetail.setProductDescription(product.getDescription());
			orderDetail.setAmount(cart.getAmount());
			orderDetail.setCreatedAt(LocalDateTime.now());
			orderDetail.setUpdatedAt(LocalDateTime.now());
			System.out.println(cart);
			orderDetailRepository.create(orderDetail);
		}
		return 1;
	}

	@Override
	public void delete(int id) {
		int deleted = productRepository.delete(id);
		if (deleted == 0) {
			throw new IllegalArgumentException("Product not found. id=" + id);
		}
	}

	@Override
	public void deleteCartByCartId(int id) {
		cartRepository.deleteByCartId(id);

	}

	@Override
	public Cart getCartById(int id) {
		return cartRepository.getById(id);
	}

	@Override
	public List<OrderDetail> getOderDetails(int orderId) {
		return orderDetailRepository.getOderDetails(orderId);
	}

	@Override
	public List<Order> getOrders(int userId) {
		return orderRepository.getOrders(userId);
	}

	@Override
	public Order getOrder(int id) {
		return orderRepository.getOrder(id);
	}

	@Override
	@Transactional
	public int createProduct(Product product) {
		return productRepository.insert(product);
	}

	@Override
	public int updateProduct(Product product) {
		return productRepository.update(product);
	}
}
