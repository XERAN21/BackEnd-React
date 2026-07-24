package com.asagao.Service.Interface;

import com.asagao.Domain.User;

public interface UserService {


	User findById(int id);

	//アカウント登録
	public int saveUser(User user);
	
	//アカウント編集
	public User updateUser(User user);

	int changePassword(int id, String newPass);

}
