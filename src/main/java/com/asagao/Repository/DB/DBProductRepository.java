package com.asagao.Repository.DB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asagao.Domain.Product;
import com.asagao.Mapper.CartMapper;
import com.asagao.Mapper.ProductMapper;
import com.asagao.Repository.Interface.ProductRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBProductRepository implements ProductRepository{

	@Autowired
	private ProductMapper ProductMapper;
	private final CartMapper cartMapper;
	
	@Override
	public List<Product> findAll(String name, String colorId) {
		return ProductMapper.findAll(name, colorId);
	}


	@Override
	public Product findById(int id) {
		return ProductMapper.findById(id);
	}

	@Override
    public int delete(int id) {
        return ProductMapper.delete(id);
    }
	
	@Override
    public int insert(Product Product) {
        return ProductMapper.insert(Product);
    }
}
	
	
	
	
	
	
	
	
	
	

