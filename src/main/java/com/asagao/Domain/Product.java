package com.asagao.Domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Product {
	private Integer id;
	private String name;
	private String description;
	private Integer price;
	private String image_url;
	private Integer color;
	private Integer deleteFlg;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
