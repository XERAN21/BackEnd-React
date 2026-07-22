package com.asagao.Repository.Interface;

import com.asagao.Domain.User;

public interface UserRepository {

	User findById(int id);
}
