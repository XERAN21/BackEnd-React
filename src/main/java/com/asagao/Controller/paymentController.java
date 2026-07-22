package com.asagao.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asagao.Domain.Cart;
import com.asagao.Domain.Product;
import com.asagao.Domain.User;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class paymentController {
	
	private final ProductService productService;
	
	@GetMapping
	public Cart[] getCartItems(HttpSession session) {
		User user = (User)session.getAttribute("user");
	      if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
	      
	      return productService.getCartItems(0);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Product[] products, HttpSession session) {
		User user = (User)session.getAttribute("user");
	      if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
	      
	      productService.proceedPayment();
	}
}
