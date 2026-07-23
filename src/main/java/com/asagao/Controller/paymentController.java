package com.asagao.Controller;

import java.util.Map;

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
import com.asagao.Domain.Order;
import com.asagao.Domain.User;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class paymentController {
	
	private final ProductService productService;
	private ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping
	public Cart[] getCartItems(HttpSession session) {
		User user = (User)session.getAttribute("user");
	      if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
	      
	      return productService.getCartItems(user.getId());
	}

	@PostMapping("/order")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody Map<String, Object> request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}

		Order order = convertToOrder(request.get("order"));
		Cart[] carts = convertToCarts(request.get("cart"));

		System.out.println(order);
		System.out.println(carts);
		
		order.setUserId(user.getId());
		productService.addOrder(order, carts);
	}

	private Order convertToOrder(Object orderData) {
		return objectMapper.convertValue(orderData, Order.class);
	}

	private Cart[] convertToCarts(Object cartData) {
		return objectMapper.convertValue(cartData, Cart[].class);
	}
}
