package com.ssafy.notice.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.notice.model.dto.Notice;

@Mapper
public interface NoticeMapper {
	
	int insert(Notice notice) throws SQLException;
	
	void update(Notice notice) throws SQLException;
	
	void delete(String articleNo) throws SQLException;
	
	Notice searchById(String articleNo) throws SQLException;
	
	List<Notice> selectAll() throws SQLException;
}
