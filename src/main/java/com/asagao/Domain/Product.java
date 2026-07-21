package com.asagao.Domain;

import java.sql.Date;

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
	private Date createdAt;
	private Date updatedAt;
}
