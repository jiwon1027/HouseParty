package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.Board;

@Mapper
public interface BoardMapper {
	
	int insert(Board board) throws SQLException;
	
	void update(Board board) throws SQLException;
	
	void delete(String articleNo) throws SQLException;
	
	Board searchById(String articleNo) throws SQLException;
	
	List<Board> selectAll() throws SQLException;
}
