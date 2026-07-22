package com.asagao.Repository.DB;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.User;
import com.asagao.Mapper.UserMapper;
import com.asagao.Repository.Interface.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBUserRepository implements UserRepository{
	
	private final UserMapper UserMapper;

	@Override
	public User findById(int id) {
		return UserMapper.findById(id);
	}
}
