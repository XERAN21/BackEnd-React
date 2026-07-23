package com.asagao.Repository.DB;

import org.springframework.stereotype.Repository;

import com.asagao.Domain.Notice;
import com.asagao.Mapper.NoticeMapper;
import com.asagao.Repository.Interface.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBNoticeRepository implements NoticeRepository {

	private final NoticeMapper noticeMapper;
	
	@Override
	public Notice[] findAll() {
		return noticeMapper.findAll();
	}

}
