package com.asagao.Service.Impl;

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

}
