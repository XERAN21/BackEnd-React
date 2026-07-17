package com.asagao.Controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asagao.Domain.Product;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class productController {
	private final ProductService productService;

	@GetMapping
	  public List<Product> list(HttpSession session) {
	      
	      return productService.getProducts();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
