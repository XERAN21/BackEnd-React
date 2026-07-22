package com.asagao.Service.Impl;

import org.springframework.stereotype.Service;

import com.asagao.Domain.User;
import com.asagao.Repository.Interface.UserRepository;
import com.asagao.Service.Interface.UserService;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public User findById(int id) {
		return userRepository.findById(id);
	}
}
