package com.asagao.Controller;


import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asagao.Domain.Cart;
import com.asagao.Domain.CartDom;
import com.asagao.Domain.Product;
import com.asagao.Domain.User;
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
	
	@DeleteMapping("/{id}")
	  public void delete(@PathVariable Integer id) {
	      productService.delete(id);
	  }
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	private Product getById(@PathVariable Integer id, HttpSession session) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/addToCart")
	public void addToCart(@RequestBody CartDom cartDom,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		Cart cart=new Cart();
		cart.setAmount(cartDom.getAmount());
		cart.setProductId(cartDom.getProductId());
		cart.setUserId(user.getId());
		productService.addToCart(cart);
	}
	
}
