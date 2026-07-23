package com.asagao.Repository.Interface;

import com.asagao.Domain.User;

public interface UserRepository {


	User findById(int id);

	//Email、パスワードから情報を取得
	User findByEmailAndPassword(String email, String password);
	
	//アカウント登録
	int save(User user);
	
	//アカウント編集
	User update(User user);
}
