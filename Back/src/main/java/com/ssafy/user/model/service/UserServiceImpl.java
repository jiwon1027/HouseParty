package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public int insert(User user) throws SQLException {
		return userMapper.insert(user);
	}

	@Override
	public User login(User user) throws SQLException {
		return userMapper.login(user);
	}

	@Override
	public void update(User user) throws SQLException {
		userMapper.update(user);
	}

	@Override
	public void delete(String id) throws SQLException {
		userMapper.delete(id);
	}
	
	//비밀번호 찾기
	@Override
	public String findpw(String id) throws SQLException {
		User user = userMapper.getUser(id);
		String temPass = getTempPassword();
		updatePassword(temPass, user.getUserId());
		return temPass;
	}

	@Override
	public void updatePassword(String temPass, String id) throws SQLException {
		User user = new User();
		user.setUserId(id);
		user.setUserPw(temPass);
		userMapper.updatePw(user);
	}

	@Override
	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
	}

	@Override
	public List<User> getUserList() throws SQLException {
		return userMapper.getUserList();
	}

	@Override
	public User getUser(String id) throws SQLException {
		return userMapper.getUser(id);
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return userMapper.getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		userMapper.saveRefreshToken(map);
	}

	

}
