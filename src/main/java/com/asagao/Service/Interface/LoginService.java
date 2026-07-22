package com.asagao.Service.Interface;

import com.asagao.Domain.User;

public interface LoginService {

	User authenticate(String email, String password);
}
