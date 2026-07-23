package com.asagao.Service.Interface;

import com.asagao.Domain.Notice;

public interface NoticeService {
	Notice[] getNotices();
	
	Notice getNoticeDetails(int noticeId);
}
