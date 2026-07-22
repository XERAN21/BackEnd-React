package com.asagao.Domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
	private Long id;
    private String email;
    private String password;
    private Integer role;
    private String lastName;
    private String firstName;
    private String postNumber;
    private String address;
    private String telNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
