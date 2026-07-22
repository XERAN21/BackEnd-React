package com.asagao.Domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Order {
	public Integer id;
	public Integer userId;
	public String creditNumber;
	public String lastName;
	public String firstName;
	public String postNumber;
	public String address;
	public String telNumber;
	public Integer sumPrice;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
}
