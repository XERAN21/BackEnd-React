package com.asagao.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.ProductRepository;
import com.asagao.Service.Interface.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

	
	
	

	

	
	
	
	
	
	
	
	
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}













	@Override
	public Product getById(int id) {
		return productRepository.findById(id);
	}

















	@Override
	public int proceedPayment() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

















	
	
}
