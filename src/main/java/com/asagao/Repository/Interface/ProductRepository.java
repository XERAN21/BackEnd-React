package com.asagao.Repository.Interface;

import java.util.List;

import com.asagao.Domain.Product;

public interface ProductRepository {
    
	List<Product> findAll();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Product findById(int id);
}
