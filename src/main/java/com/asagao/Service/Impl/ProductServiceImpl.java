package com.asagao.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.ProductRepository;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository ProductRepository;

    @Override
    public List<Product> getProducts() {
        return ProductRepository.findAll();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
