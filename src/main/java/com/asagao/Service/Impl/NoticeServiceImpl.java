package com.asagao.Service.Impl;

import org.springframework.stereotype.Service;

import com.asagao.Domain.Notice;
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

}
