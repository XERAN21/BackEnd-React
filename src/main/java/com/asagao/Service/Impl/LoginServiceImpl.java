package com.asagao.Service.Impl;

import org.springframework.stereotype.Service;

import com.asagao.Domain.User;
import com.asagao.Repository.Interface.UserRepository;
import com.asagao.Service.Interface.LoginService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final UserRepository userRepository;

	/**
	 * ログイン認証を行うメソッド
     * @param email フロントから届いたメール
     * @param password フロントから届いた生のパスワード
     * @return 認証成功時はUserオブジェクト、失敗時はnull
	 */
	@Override
	public User authenticate(String email, String password) {
		// 1. メールアドレスをキーに、DBからユーザー情報を取得
		User user = userRepository.findByEmailAndPassword(email, password);
		
		// ユーザーが存在しない場合は、その時点でログイン失敗(null)とする
		if(user == null) {
			return null; 
		}
		
		return user; 
	}

}
