package com.ssafy.notice.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.notice.model.dto.Notice;

public interface NoticeService {

	int insert(Notice notice) throws SQLException;
	
	void update(Notice notice) throws SQLException;
	
	void delete(String articleNo) throws SQLException;
	
	Notice searchById(String articleNo) throws SQLException;
	
	List<Notice> selectAll() throws SQLException;
}
