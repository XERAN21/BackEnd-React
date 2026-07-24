package com.asagao.Service.Interface;

import com.asagao.Domain.User;

public interface LoginService {

	//メールとパスワードからユーザー情報を取得
	User authenticate(String email, String password);
}
