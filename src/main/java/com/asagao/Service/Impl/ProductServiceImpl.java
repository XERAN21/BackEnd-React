package com.asagao.Service.Impl;

import org.springframework.stereotype.Service;

import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.ProductRepository;
import com.asagao.Service.Interface.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	
	

	
	
	
	
	
	
	
	
	
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}














	@Override
	public Product getById(int id) {
		return productRepository.findById(id);
	}
	
	
}
