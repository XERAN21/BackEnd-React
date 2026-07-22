package com.asagao.Repository.DB;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.User;
import com.asagao.Mapper.UserMapper;
import com.asagao.Repository.Interface.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBUserRepository implements UserRepository {

	private final UserMapper userMapper;

	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userMapper.findByEmailAndPassword(email, password);
	}

	@Override
	public int save(User user) {
		return userMapper.save(user);
	}


	@Override
	public User findById(int id) {
		return userMapper.findById(id);
	}
}