package com.asagao.Domain;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private Integer id;
	private String name;
	private String description;
	private Integer price;
	private String image_url;
	private MultipartFile image;
	private Integer color;
	private Integer deleteFlg;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
