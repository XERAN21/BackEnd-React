package com.asagao.Repository.Interface;

import com.asagao.Domain.Notice;

public interface NoticeRepository {
	Notice[] findAll();
	
	Notice findById(int noticeId);
}
