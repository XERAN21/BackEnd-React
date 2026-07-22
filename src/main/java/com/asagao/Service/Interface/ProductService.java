package com.asagao.Service.Interface;


import java.util.List;

import com.asagao.Domain.Cart;
import com.asagao.Domain.Product;

public interface ProductService {

	public List<Product> getProducts();
		
	Product getById(int id);

	int proceedPayment();
	
	Cart[] getCartItems(int userId);

}
