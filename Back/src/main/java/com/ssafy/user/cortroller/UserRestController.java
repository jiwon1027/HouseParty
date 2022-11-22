package com.ssafy.user.cortroller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.ssafy.user.jwt.service.JwtService;
import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody User user) {
		try {
			userService.insert(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("이미 존재하는 아이디입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login") 
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			User loginUser = userService.login(user);
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken("userid", loginUser.getUserId(), "isAdmin", loginUser.isAdmin());// key, data
				String refreshToken = jwtService.createRefreshToken("userid", loginUser.getUserId(), "isAdmin", loginUser.isAdmin());// key, data
				userService.saveRefreshToken(loginUser.getUserId(), refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", "success");
//				session.setAttribute("userinfo", loginUser);
				status = HttpStatus.ACCEPTED;
			}
			else {
				return new ResponseEntity<String>("올바른 아이디와 패스워드를 입력해주세요", HttpStatus.BAD_REQUEST);
			}
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
//	@GetMapping("/logout")
//	public ResponseEntity<?> logout(String userid) {
//		try {
//			userService.deleRefreshToken(userid);
//			return new ResponseEntity<Void>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
////		session.invalidate();
//	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody User user) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.update(user);
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} catch (SQLException e) {
			resultMap.put("message", "회원 정보 수정 에러");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.delete(id);
			userService.deleRefreshToken(id);
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} catch (SQLException e) {
			resultMap.put("message", "회원 정보 삭제 에러");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (Exception e) {
			resultMap.put("message", "회원 정보 삭제 에러");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/findpw/{id}")
	public ResponseEntity<?> findpw(@PathVariable String id) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			String tempPass = userService.findpw(id);
			resultMap.put("temPass", tempPass);
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} catch (SQLException e) {
			resultMap.put("message", "비밀번호 찾기 에러");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getUserList() {
		try {
			List<User> users = userService.getUserList();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable String id) {
		try {
			User user = userService.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//jwt
	
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(@PathVariable("userid") String userid, HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			try {
//				로그인 사용자 정보.
				User loginUser = userService.getUser(userid);
				resultMap.put("userInfo", loginUser);
				resultMap.put("message", "success");
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				resultMap.put("message", "올바른 사용자가 아닙니다");
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			resultMap.put("message", "fail");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody User user, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		if (jwtService.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(user.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userid", user.getUserId(), "isAdmin", user.isAdmin());
				resultMap.put("access-token", accessToken);
				resultMap.put("message", "success");
				status = HttpStatus.ACCEPTED;
			}
		} else {
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/logout/{userid}")
	public ResponseEntity<?> removeToken(@PathVariable("userid") String userid) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userid);
			resultMap.put("message", "success");
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			resultMap.put("message", "로그아웃 에러");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	
}
