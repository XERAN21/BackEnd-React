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
     * @param rawPassword フロントから届いた生のパスワード
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
		
		// 2. 生のパスワードと、DBにあったハッシュ化パスワードを照合する
        // 一致すれば true、間違っていれば false が返る
//		boolean isPasswordMach = BCrypt.checkpw(password, user.getPassword());
//		
//		if(isPasswordMach) {
//			// パスワードが合っていれば、ログイン成功としてユーザー情報を返す
//			return user; 
//		}
		// パスワードが違っていればログイン失敗(null)
		return user; 
	}

}
