package com.asagao.Repository.Interface;

import com.asagao.Domain.User;

public interface UserRepository {

	//Emailから情報を取得
	User findByEmailAndPassword(String email, String password);
	
	int save(User user);
}
