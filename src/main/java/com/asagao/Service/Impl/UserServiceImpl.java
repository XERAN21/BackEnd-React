package com.asagao.Service.Impl;

import org.springframework.stereotype.Service;

import com.asagao.Domain.User;
import com.asagao.Repository.Interface.UserRepository;
import com.asagao.Service.Interface.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Override
	public int saveUser(User user) {
		return userRepository.save(user);
	}

}
