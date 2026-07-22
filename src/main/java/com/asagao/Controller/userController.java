package com.asagao.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.asagao.Domain.User;
import com.asagao.Service.Interface.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class userController {

	private final UserService userService;

	//ユーザー登録
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public int saveUser(
			@Valid @RequestBody User user,
			HttpSession session) {
		
		int result = userService.saveUser(user);
		return result;
	}
}
