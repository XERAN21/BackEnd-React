package com.asagao.Repository.DB;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.Product;
import com.asagao.Mapper.CartMapper;
import com.asagao.Mapper.ProductMapper;
import com.asagao.Repository.Interface.ProductRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBProductRepository implements ProductRepository{

	private final ProductMapper ProductMapper;
	private final CartMapper cartMapper;
	
	@Override
    public List<Product> findAll() {
		return ProductMapper.findAll();
    }

	@Override
	public Product findById(int id) {
		return ProductMapper.findById(id);
	}

	
	
	
	
	
	
	
	
	
	
	
}
