package com.asagao.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class productController {
	
	private final ProductRepository productRepository;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	private Product getById(@PathVariable Integer id, HttpSession session) {
		return productRepository.findById(id);
	}
	
}
