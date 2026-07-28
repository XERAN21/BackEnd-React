package com.asagao.Service.Impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.asagao.Domain.Cart;
import com.asagao.Domain.Order;
import com.asagao.Domain.OrderDetail;
import com.asagao.Domain.Product;
import com.asagao.Repository.Interface.CartRepository;
import com.asagao.Repository.Interface.OrderDetailRepository;
import com.asagao.Repository.Interface.OrderRepository;
import com.asagao.Repository.Interface.ProductRepository;
import com.asagao.Service.Interface.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	private final OrderRepository orderRepository;
	private final OrderDetailRepository orderDetailRepository;
	private final CartRepository cartRepository;
	
	//画像保存のためのやつ
	private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

	@Override
	public List<Product> findAll(String name, String colorId) {
		return productRepository.findAll(name, colorId);
	}

	@Override
	public Product getById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public void addToCart(Cart cart) {
		cartRepository.addToCart(cart);
	}

	@Override
	public Cart[] getCartItems(int userId) {
		return cartRepository.findAll(userId);
	}

	@Override
	public Cart countByProductId(Cart cart) {
		return cartRepository.countByProductId(cart);
	}

	@Override
	public void update(Cart cart) {
		cartRepository.update(cart);
	}

	public void clearCartItems(int userId) {
		cartRepository.delete(userId);
	}

	@Override
	@Transactional
	public int addOrder(Order order, Cart[] carts) {
		order.setCreatedAt(LocalDateTime.now());
		order.setUpdatedAt(LocalDateTime.now());
		orderRepository.create(order);
		System.out.println(order.getSumPrice());

		for (Cart cart : carts) {
			OrderDetail orderDetail = new OrderDetail();
			Product product = productRepository.findById(cart.getProductId());
			orderDetail.setOrderId(order.getId());
			orderDetail.setProductId(cart.getProductId());
			orderDetail.setProductName(product.getName());
			orderDetail.setProductPrice(product.getPrice());
			orderDetail.setProductImage_url(product.getImage_url());
			orderDetail.setProductDescription(product.getDescription());
			orderDetail.setAmount(cart.getAmount());
			orderDetail.setCreatedAt(LocalDateTime.now());
			orderDetail.setUpdatedAt(LocalDateTime.now());
			System.out.println(cart);
			orderDetailRepository.create(orderDetail);
		}
		return 1;
	}

	@Override
	public void delete(int id) {
		int deleted = productRepository.delete(id);
		if (deleted == 0) {
			throw new IllegalArgumentException("Product not found. id=" + id);
		}
	}

	@Override
	public void deleteCartByCartId(int id) {
		cartRepository.deleteByCartId(id);

	}

	@Override
	public Cart getCartById(int id) {
		return cartRepository.getById(id);
	}

	@Override
	public List<OrderDetail> getOderDetails(int orderId) {
		return orderDetailRepository.getOderDetails(orderId);
	}

	@Override
	public List<Order> getOrders(int userId) {
		return orderRepository.getOrders(userId);
	}

	@Override
	public Order getOrder(int id) {
		return orderRepository.getOrder(id);
	}

	@Override
    @Transactional
    public int createProduct(Product product) {
		
		MultipartFile imageFile = product.getImage();
		
		if(imageFile != null && !imageFile.isEmpty()) {
			String relativePath = saveImage(imageFile);
			product.setImage_url(relativePath);
		}else {
			product.setImage_url(null);
		}
		
        return productRepository.insert(product);
    }

	@Override
	public int updateProduct(Product product) {
		
		Product existingProduct = productRepository.findById(product.getId());
		MultipartFile imageFile = product.getImage();
		
		if(imageFile != null && !imageFile.isEmpty()) {
			
			String ralativePath = saveImage(imageFile);
			product.setImage_url(ralativePath);
		}else {
			product.setImage_url(existingProduct.getImage_url());
		}
		
		return productRepository.update(product);
	}
	
	//画像保存処理
	@Override
	public String saveImage(MultipartFile file) {
        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originalFilename = file.getOriginalFilename();
            String savedFilename = UUID.randomUUID().toString() + "_" + originalFilename;

            File destFile = new File(Paths.get(UPLOAD_DIR, savedFilename).toString());
            file.transferTo(destFile);

            return "/images/" + savedFilename;

        } catch (IOException e) {
            throw new RuntimeException("ファイルの保存に失敗しました", e);
        }
    }
}
