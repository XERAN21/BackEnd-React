package com.asagao.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asagao.Domain.Cart;
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
	@Transactional
	public int proceedPayment() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
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

}
