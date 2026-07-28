package com.asagao.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Notice;

@Mapper
public interface NoticeMapper {
	Notice[] findAll();
	
	Notice findById(int noticeId);
	
	int create(Notice notice);
	//お知らせ編集
	int update(Notice notice);
	
	void delete(int id);
}
