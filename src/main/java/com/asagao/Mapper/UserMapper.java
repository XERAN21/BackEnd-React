package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.asagao.Domain.User;

@Mapper
public interface UserMapper {

	//メールアドレス,パスワードをもとに取得
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	int save(User user);
}
