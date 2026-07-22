package com.asagao.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asagao.Domain.User;
import com.asagao.Service.Interface.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class loginController {

	private final LoginService loginService;
	
	@PostMapping("/login")
	public User login(
			@RequestBody User user, HttpSession session) {
	    user = loginService.authenticate(
	            user.getEmail(), 
	            user.getPassword());
	    
	    if (user == null) {
	        throw new ResponseStatusException(
	                HttpStatus.UNAUTHORIZED, 
	                "Invalid login");
	    }
	    session.setAttribute("user", user);
	    return user;
			
//			@RequestBody Map<String, String> request,
//			HttpSession session) {
//		// Spring Bootが自動でJSONを分解し、Mapに入れる
//		String email = request.get("email");
//		String password = request.get("password");
//		
//		// サービス層のログイン判定を呼び出し
//		User user = loginService.authenticate(email, password);
//		
//		if (user == null) {
//	        throw new ResponseStatusException(
//	                HttpStatus.UNAUTHORIZED, 
//	                "Invalid login");
//	    }
//		// セッションにログインユーザーの情報を保存（ブラウザにセッションCookieが送られます）
//	    session.setAttribute("user", user);
//	    System.out.println(user);
//	    // 成功時はUserオブジェクトをそのまま返す（自動的にJSONに変換されてReactに届きます）
//	    return user;
		
	}
	
	@GetMapping("/me")
    public User login(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, 
                    "Invalid login");
        }
        return user;
    }
    
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
