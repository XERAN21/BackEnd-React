package com.asagao.Domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDetail {
	public Integer id;
	public Integer orderId;
	public Integer productId;
	public Integer amount;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
}
