package com.asagao.Repository.DB;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.Notice;
import com.asagao.Domain.NoticeRead;
import com.asagao.Mapper.NoticeMapper;
import com.asagao.Mapper.NoticeReadMapper;
import com.asagao.Repository.Interface.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBNoticeRepository implements NoticeRepository {

	private final NoticeMapper noticeMapper;
	private final NoticeReadMapper noticeReadMapper;
	
	@Override
	public Notice[] findAll() {
		
		Notice[] notices = noticeMapper.findAll();
		
		for (Notice notice : notices) {
			System.out.println("From Repository:");
			System.out.println(notice);
		}
		
		return noticeMapper.findAll();
	}

	@Override
	public Notice findById(int noticeId) {
		return noticeMapper.findById(noticeId);
	}

	@Override
	public NoticeRead[] getAll(int userId) {
		return noticeReadMapper.getAll(userId);
	}
	
	

}
