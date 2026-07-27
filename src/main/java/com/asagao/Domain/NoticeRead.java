package com.asagao.Domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticeRead {
	private Integer Id;
	private Integer NoticeId;
	private Integer UserId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
