package com.asagao.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asagao.Domain.Product;

@Mapper
public interface ProductMapper {

	List<Product> findAll(@Param("name") String name, @Param("colorId") String colorId);
	
	Product findById(int id);
	
//	void addToCart(Product product);

	int delete(@Param("id") int id);
}
