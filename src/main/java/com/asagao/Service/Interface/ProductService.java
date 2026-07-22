package com.asagao.Service.Interface;


import java.util.List;

import com.asagao.Domain.Product;

public interface ProductService {

	public List<Product> getProducts();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Product getById(int id);
	
	void addToCart(Product product);
}
