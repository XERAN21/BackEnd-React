package com.asagao.Repository.Interface;

import com.asagao.Domain.Notice;
import com.asagao.Domain.NoticeRead;

public interface NoticeRepository {
	Notice[] findAll();
	
	Notice findById(int noticeId);
	
	NoticeRead[] getAll(int userId);
	
	int MarkRead(NoticeRead noticeRead);
	
	int create(Notice notice);
}
