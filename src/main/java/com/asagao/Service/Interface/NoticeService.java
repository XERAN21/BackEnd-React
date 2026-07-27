package com.asagao.Service.Interface;

import com.asagao.Domain.Notice;
import com.asagao.Domain.NoticeRead;

public interface NoticeService {
	Notice[] getNotices();
	
	Notice getNoticeDetails(int noticeId);
	
	NoticeRead[] getUnreadNotices(int userId);
	
	int MarkasRead(int noticeId,int userId);
}
