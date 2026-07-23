package com.asagao.Repository.Interface;

import java.util.List;

import com.asagao.Domain.Product;

public interface ProductRepository {
    
	List<Product> findAll();
	
	
	int delete(int id);
	
	
	
	
	
	
	
	
	
	
	
	Product findById(int id);



	
	
	
	
	
	
	
	
	
	
}
