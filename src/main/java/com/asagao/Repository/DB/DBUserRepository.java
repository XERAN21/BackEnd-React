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

	//メールとパスワードからユーザー情報取得
	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userMapper.findByEmailAndPassword(email, password);
	}

	//アカウント登録
	@Override
	public int save(User user) {
		return userMapper.save(user);
	}


	@Override
	public User findById(int id) {
		return userMapper.findById(id);
	}

	//アカウント編集
	@Override
	public User update(User user) {
		int updated = userMapper.update(user);
		 // もし更新件数が0なら、ここでエラー（例外）を投げる
		if (updated == 0) {
			throw new IllegalArgumentException("User not found. id=" + user.getId());
		}
		// ② 更新が成功したので、マッパーから最新のデータを取得して返す
		return userMapper.findById(user.getId());
	}
}