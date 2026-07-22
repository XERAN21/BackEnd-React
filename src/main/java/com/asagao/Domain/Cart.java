package com.asagao.Domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Cart {
	private Integer id;
	private Integer userId;
	private Integer productId;
	private Integer amount;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
