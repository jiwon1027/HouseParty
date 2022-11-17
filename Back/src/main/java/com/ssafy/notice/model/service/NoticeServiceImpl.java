package com.ssafy.notice.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.notice.model.dto.Notice;
import com.ssafy.notice.model.mapper.NoticeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	
	NoticeMapper noticeMapper;
	
	
	@Autowired
	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		super();
		this.noticeMapper = noticeMapper;
	}

	@Override
	public int insert(Notice notice) throws SQLException {
		return noticeMapper.insert(notice);
	}

	@Override
	public void update(Notice notice) throws SQLException {
		noticeMapper.update(notice);
	}

	@Override
	public void delete(String articleNo) throws SQLException {
		noticeMapper.delete(articleNo);
	}

	@Override
	public Notice searchById(String articleNo) throws SQLException {
		return noticeMapper.searchById(articleNo);
	}

	@Override
	public List<Notice> selectAll() throws SQLException {
		return noticeMapper.selectAll();
	}



}
