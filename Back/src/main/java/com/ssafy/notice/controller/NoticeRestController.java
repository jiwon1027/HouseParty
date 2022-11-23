package com.ssafy.notice.controller;

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

import com.ssafy.notice.model.dto.Notice;
import com.ssafy.notice.model.service.NoticeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/notice")
public class NoticeRestController {
	
	private NoticeService service;
	
	@Autowired
	public NoticeRestController(NoticeService service) {
		super();
		this.service = service;
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Notice notice) {
		try {
			service.insert(notice);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{article-no}")
	public ResponseEntity<?> selectById(@PathVariable("article-no") String articleNo) {
		try {
			Notice notice = service.searchById(articleNo);
			return new ResponseEntity<Notice>(notice, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> selectAll() {
		try {
			List<Notice> notices = service.selectAll();
			return new ResponseEntity<List<Notice>>(notices, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Notice notice) {
		try {
			service.update(notice);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{article-no}")
	public ResponseEntity<?> delete(@PathVariable("article-no") String articleNo) {
		try {
			service.delete(articleNo);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
