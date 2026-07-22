package com.asagao.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Product;

@Mapper
public interface ProductMapper {

	 List<Product> findAll();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Product findById(int id);
	
	void addToCart(Product product);
}
