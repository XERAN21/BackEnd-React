package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Notice;

@Mapper
public interface NoticeMapper {
	Notice[] findAll();
	
	Notice findById(int noticeId);
	
	//お知らせ編集
	int update(Notice notice);
}
