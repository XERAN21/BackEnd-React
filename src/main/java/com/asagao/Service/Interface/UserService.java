package com.asagao.Service.Interface;

import com.asagao.Domain.User;

public interface UserService {


	User findById(int id);

	public int saveUser(User user);
}
