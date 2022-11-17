package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	BoardMapper boardMapper;

	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public int insert(Board board) throws SQLException {
		return boardMapper.insert(board);
	}

	@Override
	public void update(Board board) throws SQLException {
		boardMapper.update(board);
	}

	@Override
	public void delete(String articleNo) throws SQLException {
		boardMapper.delete(articleNo);
	}

	@Override
	public Board searchById(String articleNo) throws SQLException {
		return boardMapper.searchById(articleNo);
	}

	@Override
	public List<Board> selectAll() throws SQLException {
		return boardMapper.selectAll();
	}

}
