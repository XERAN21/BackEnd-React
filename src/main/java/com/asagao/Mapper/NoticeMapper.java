package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Notice;

@Mapper
public interface NoticeMapper {
	Notice[] findAll();
}
