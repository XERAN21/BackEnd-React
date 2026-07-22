package com.asagao.Controller;


import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.ProductRepository;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class productController {

	private final ProductService productService;

	
	private final ProductRepository productRepository;

	@GetMapping
	  public List<Product> list(HttpSession session) {
	      
	      return productService.getProducts();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	private Product getById(@PathVariable Integer id, HttpSession session) {
		return productRepository.findById(id);
	}
	
	@GetMapping("/initCart")
	public Product initCart(@RequestBody Product product,HttpSession session) {
		List<Product> cart=(List<Product>) session.getAttribute("cart");
		if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(product);
        session.setAttribute("cart", cart);
        return product;
	}
	
}
