package com.asagao.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asagao.Domain.Cart;
import com.asagao.Domain.Order;
import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.CartRepository;
import com.asagao.Repository.Interface.ProductRepository;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
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
	public int addOrder(Order order) {
		return 0;
	}

	@Override
	public int addOrderDetail(Cart[] carts) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
