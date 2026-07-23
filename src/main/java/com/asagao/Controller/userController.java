package com.asagao.Controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asagao.Domain.User;
import com.asagao.Service.Interface.UserService;

@RestController
@RequestMapping("/api/auth")

public class userController {

	private final UserService userService;

	public userController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/me")
	public ResponseEntity<Map<String, Object>> getCurrentUser(HttpSession session) {
		Object userIdAttribute = session.getAttribute("userId");

		if (userIdAttribute == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		int userId = (int) userIdAttribute;
		User user = userService.findById(userId);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		Map<String, Object> response = new HashMap<>();
		response.put("id", user.getId());
		response.put("email", user.getEmail());
		response.put("role", user.getRole());
		response.put("last_name", user.getLastName());
		response.put("first_name", user.getFirstName());

		return ResponseEntity.ok(response);
	}

	//ユーザー登録
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public int saveUser(
			@Valid @RequestBody User user,
			HttpSession session) {

		int result = userService.saveUser(user);
		return result;
	}

	//userIDをもとに1つのユーザー情報取得
	@GetMapping("{id}")
	public User getUserId(
			@PathVariable Integer id,
			HttpSession session) {
		
		//HttpSessionからユーザー情報を取得する
		User loginUser = (User) session.getAttribute("user");
		//ログインしているかチェック
		if (loginUser == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}
		//ログインしている人が「本人」かどうかチェック 等しくない場合(!)エラー
		if (!loginUser.getId().equals(id)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "他人のアカウントは編集できません");
		}
		
		User user = userService.findById(id);
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
		}
		return userService.findById(id);
	}

	//アカウント編集機能
	@PutMapping("/{id}")
	public User updateUser(
			@PathVariable Integer id,
			@Valid @RequestBody User user,
			HttpSession session) {

		//HttpSessionからユーザー情報を取得する
		User loginUser = (User) session.getAttribute("user");
		//ログインしているかチェック
		if (loginUser == null) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
		}
		//ログインしている人が「本人」かどうかチェック 等しくない場合(!)エラー
		if (!loginUser.getId().equals(id)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "他人のアカウントは編集できません");
		}

		user.setId(id);
		return userService.updateUser(user);
	}

}
