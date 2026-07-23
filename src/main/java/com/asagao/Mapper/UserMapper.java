package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asagao.Domain.User;

@Mapper
public interface UserMapper {


	User findById(int id);

	//メールアドレス,パスワードをもとに取得
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	//アカウント登録
	int save(User user);
	
	//アカウント編集
	int update(User user);
}
