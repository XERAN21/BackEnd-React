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
	private Integer delete_flg;
	private Date created_at;
	private Date updated_at;
}
