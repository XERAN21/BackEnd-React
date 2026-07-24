package com.asagao.Repository.Interface;

import com.asagao.Domain.User;

public interface UserRepository {


	User findById(int id);

	//Emailから情報を取得
	User findByEmailAndPassword(String email, String password);
	
	int save(User user);
	
	int changePassword(int id, String newPass);
}
