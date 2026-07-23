package com.asagao.Domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Notice {
	private Integer Id;
	private String title;
	private String body;
	private Integer visibilityFlag;
	private Integer deleteFlg;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
}
