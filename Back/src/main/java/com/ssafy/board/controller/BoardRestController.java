package com.ssafy.board.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/board")
public class BoardRestController {
	
	private BoardService service;
	
	
	@Autowired
	public BoardRestController(BoardService service) {
		System.out.println("BoardRestController 생성자 호출");
		this.service = service;
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Board board) {
		try {
			service.insert(board);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{article-no}")
	public ResponseEntity<?> selectById(@PathVariable("article-no") String articleNo) {
		try {
			Board board = service.searchById(articleNo);
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> selectAll() {

		
		
		try {
			System.out.println(11111111);
			List<Board> boards = service.selectAll();
			System.out.println(22222222);

			return new ResponseEntity<List<Board>>(boards, HttpStatus.OK);

		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Board board) {
		try {
			service.update(board);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{article-no}")
	public ResponseEntity<?> delete(@PathVariable("article-no") String articleNo) {
		try {
			System.out.println("delete");
			service.delete(articleNo);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}






