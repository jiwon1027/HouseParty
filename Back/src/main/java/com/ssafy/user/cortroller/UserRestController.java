package com.ssafy.user.cortroller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserRestController {
	
	UserService service;
	
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody User user) {
		try {
			service.insert(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login") 
	public ResponseEntity<?> login(@RequestBody Map<String, String> map, HttpSession session) {
		System.out.println(map);
		try {
			User user = service.login(map);
			if (user != null) {
				session.setAttribute("userinfo", user);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("올바른 아이디와 패스워드를 입력해주세요", HttpStatus.BAD_REQUEST);
			}
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody User user) {
		try {
			service.update(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findpw/{id}")
	public ResponseEntity<?> findpw(@PathVariable String id) {
		try {
			service.findpw(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> getUserList() {
		try {
			List<User> users = service.getUserList();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable String id) {
		try {
			User user = service.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
