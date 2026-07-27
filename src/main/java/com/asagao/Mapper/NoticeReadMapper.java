package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.NoticeRead;

@Mapper
public interface NoticeReadMapper {
	NoticeRead[] getAll(int userId);
}
