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

	@Override
	public int MarkRead(NoticeRead noticeRead) {
		return noticeReadMapper.MarkRead(noticeRead);
	}

	//お知らせ編集
	@Override
	public Notice update(Notice notice) {
		int updated = noticeMapper.update(notice);
		 // もし更新件数が0なら、ここでエラー（例外）を投げる
		if (updated == 0) {
			throw new IllegalArgumentException("Notice not found. id=" + notice.getId());
		}
		// ② 更新が成功したので、マッパーから最新のデータを取得して返す
		return noticeMapper.findById(notice.getId());
	}
	
	

}
