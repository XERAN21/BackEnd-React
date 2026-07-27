package com.asagao.Service.Impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.asagao.Domain.Notice;
import com.asagao.Domain.NoticeRead;
import com.asagao.Repository.Interface.NoticeRepository;
import com.asagao.Service.Interface.NoticeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeRepository noticeRepository;
	
	@Override
	public Notice[] getNotices() {
		return noticeRepository.findAll();
	}

	@Override
	public Notice getNoticeDetails(int noticeId) {
		return noticeRepository.findById(noticeId);
	}

	@Override
	public NoticeRead[] getUnreadNotices(int userId) {
		return noticeRepository.getAll(userId);
	}

	@Override
	public int MarkasRead(int noticeId, int userId) {
		
		NoticeRead noticeRead = new NoticeRead();
		noticeRead.setNoticeId(noticeId);
		noticeRead.setUserId(userId);
		noticeRead.setCreatedAt(LocalDateTime.now());
		noticeRead.setUpdatedAt(LocalDateTime.now());
		
		return noticeRepository.MarkRead(noticeRead);
	}

}
