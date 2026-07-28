package com.asagao.Controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asagao.Domain.Cart;
import com.asagao.Domain.CartDom;
import com.asagao.Domain.Order;
import com.asagao.Domain.OrderDetail;
import com.asagao.Domain.Product;
import com.asagao.Domain.User;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class productController {

	private final ProductService productService;


	@GetMapping
	public List<Product> getProducts(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "colorId", required = false) String colorId) {
		
		return productService.findAll(name, colorId);
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Integer id) {
		  return productService.getById(id); 
	}
	
	@DeleteMapping("/{id}")
	  public void delete(@PathVariable Integer id) {
	      productService.delete(id);
	  }
	
	@PostMapping
	  public int create(@RequestBody Product product, HttpSession session) {
	      User user = (User)session.getAttribute("user");
	      if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
	      product.setId(user.getId());
	      return productService.createProduct(product);
	  }

	
	
	
	
	
	
	
	
	
	
	
	
	
	



	@PostMapping("/addToCart")
	public void addToCart(@RequestBody CartDom cartDom,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		Cart cart = new Cart();
		cart.setAmount(cartDom.getAmount());
		cart.setProductId(cartDom.getProductId());
		cart.setUserId(user.getId());
		if (productService.countByProductId(cart) != null) {
			cart.setAmount(productService.countByProductId(cart).getAmount() + cart.getAmount());
			productService.update(cart);
		} else {
			productService.addToCart(cart);
		}

	}

	@DeleteMapping("/cart/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}
		if (user.getId() != productService.getCartById(id).getUserId()) {
			System.out.println(user.getId());
			System.out.println(productService.getCartById(id).getUserId());
			System.out.println(productService.getCartById(id));
			System.out.println(id);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}

		productService.deleteCartByCartId(id);

	}

	@GetMapping("/order")
	public List<Order> getOrders(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}
		return productService.getOrders(user.getId());
	}

	@GetMapping("/order/detail/{id}")
	public List<OrderDetail> getOrderDetails(@PathVariable Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}
		if (productService.getOrder(id).userId != user.getId()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}
		
		return productService.getOderDetails(id);
	}
	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}if (productService.getOrder(id).userId != user.getId()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}
		return productService.getOrder(id);
	}

}
