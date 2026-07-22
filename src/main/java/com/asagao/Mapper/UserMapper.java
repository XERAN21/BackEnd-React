package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.User;

@Mapper
public interface UserMapper {

	User findById(int id);
}
