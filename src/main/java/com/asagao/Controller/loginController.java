package com.asagao.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//ログイン機能
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
	}
	
	//ログインを保持する機能
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
}
